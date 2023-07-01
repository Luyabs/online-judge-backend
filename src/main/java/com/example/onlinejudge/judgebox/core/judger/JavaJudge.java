package com.example.onlinejudge.judgebox.core.judger;

import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import org.apache.commons.exec.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java判题机
 */
@Component
public class JavaJudge implements Judge {
//    @Value("${code-file-dir.java}")
    @Value("")
    private String fileDirectoryName;  // 暂存的代码文件和编译后的字节码文件存放位置

    @Override
    public Submission judge(Submission submission, List<TestCase> testCases, Problem problemLimitCase) {
        double runTimeLimit = 1024, memoryLimit = 0;        // 暂时没用上memoryLimit
        if (problemLimitCase.getRuntimeLimit() != null && problemLimitCase.getRuntimeLimit() >= 1024)
            runTimeLimit = problemLimitCase.getRuntimeLimit();
        String code = submission.getCode();
        String codeFileName = "Java" + DigestUtils.md5DigestAsHex((new Random().nextInt(1000) + submission.getCode()).getBytes()).substring(0, 15);
        if (code.contains("import") || code.contains("package")) {   // 不允许引入任何包
            ServiceException.throwException("我们已为代码引入了指定的包, 代码中不允许再次出现import与package关键字");
        }
        try {
            code = preHandleCode(code, codeFileName);
            saveCodeToFile(code, codeFileName + ".java");

            compileUserCode(codeFileName + ".java");
            int passCaseNum = 0;
            int totalCaseNum = submission.getIsDebug() ? 1 : testCases.size();
            for (TestCase testCase : testCases) {   // 执行用例
                if (runUserCode(codeFileName, submission, testCase, runTimeLimit, memoryLimit))
                    passCaseNum++;
                else
                    break;  // 失败则立即退出
                if (submission.getIsDebug())
                    break; // 调试只运行第一个用例
            }
            if (passCaseNum == testCases.size() || (passCaseNum == 1 && submission.getIsDebug())) {
                submission.setIsSuccess(true);
                submission.setPassTestCaseNum(passCaseNum);
            } else {
                setSubmissionErrorType(submission, "Wrong Answer (passed: " + passCaseNum + "/" + totalCaseNum + ")");
            }
        } catch(ServiceException ex){
            removeFile(codeFileName);
            return setSubmissionErrorType(submission, ex.getMessage());
        } finally {
            removeFile(codeFileName);
        }
        return submission;
    }

    /**
     * 预处理用户代码(替换import文件 + 修改类名)
     */
    private String preHandleCode(String code, String codeFileName) {
        // 限制头文件
        code = """
                import java.util.*;
                import java.math.*;
                import java.text.*;
                import java.lang.*;
                import java.security.Permission;
                """
                + code;

        // 首先替换类名为 C(submission_id)
        String pattern = "public\\s+class\\s+[A-Za-z\\d]+";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(code);

        if (matcher.find()) {
            String className = matcher.group();
            code = code.replace(className, "public class " + codeFileName);
        } else {
            throw new ServiceException("没有公共类 (public class)");
        }

        // 加SecurityManager
        pattern = "public class "+ codeFileName + "[A-Za-z\\d\s]+\\{";
        regex = Pattern.compile(pattern);
        matcher = regex.matcher(code);
        if (matcher.find()) {
            String matching = matcher.group();
            String appendStr =
                    """
                    
                    static {
                        System.setSecurityManager(new SecurityManager() {
                            public void checkPermission(Permission perm) {
                                System.out.println("you cannot use danger system call function");
                                throw new SecurityException("you cannot use danger system call function");
                            }
                        });
                    }      
                    """;
            code = code.replace(matching, matching + appendStr);
        } else {
            throw new ServiceException("没有公共类 (public class)");
        }

        return code;
    }

    /**
     * 将代码保存到文件
     */
    private void saveCodeToFile(String code, String codeFileName) {
        try (FileWriter fileWriter = new FileWriter(fileDirectoryName + codeFileName)) {
            fileWriter.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 编译代码
     */
    private void compileUserCode(String codeFileName) {
        CommandLine commandLine = new CommandLine("javac").addArgument(fileDirectoryName + codeFileName);
        DefaultExecutor executor = new DefaultExecutor();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        executor.setStreamHandler(new PumpStreamHandler(outputStream, errorStream));

        try {
            executor.execute(commandLine);  // 执行指令 编译不产生输出
        } catch (IOException ex) {  // 编译失败
            try {
                String errMessage = errorStream.toString("GBK");
                throw new ServiceException("[编译失败] " + errMessage);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();      // 一般不会执行这条, GBK肯定支持
            }
        }
    }

    /**
     * 运行代码
     */
    private boolean runUserCode(String codeFileName, Submission submission, TestCase testCase, double runTimeLimit, double memoryLimit) {
        DefaultExecutor executor = new DefaultExecutor();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        ExecuteWatchdog watchdog = new ExecuteWatchdog((long) runTimeLimit);   // 看门狗

        executor.setStreamHandler(new PumpStreamHandler(outputStream, errorStream));
        executor.setWatchdog(watchdog);

        String input = testCase.getInput();
        if (input == null)
            throw new ServiceException("用例异常，用例缺少输入");
        String[] separatedInputs = input.split("\n");

        CommandLine commandLine = new CommandLine("java")
                .addArgument(fileDirectoryName + codeFileName);

        for (String separatedInput : separatedInputs) {
            commandLine.addArgument(separatedInput);
        }
        try {
            double startTime = System.nanoTime();
            executor.execute(commandLine);  // 执行指令
            watchdog.stop();
            submission.setRuntime((System.nanoTime() - startTime) / 1000000);
            String codeResult = outputStream.toString("GBK");
            submission.setCodeResult(codeResult);
            return codeResult.trim().equals(testCase.getOutput().trim());
        } catch (ExecuteException ex) {     // 运行超时
            if (watchdog.killedProcess()) {
                submission.setRuntime(runTimeLimit);
                throw new ServiceException("[运行超时] " + runTimeLimit);
            }
        } catch (IOException ex) {  // 编译失败
            try {
                String errMessage = errorStream.toString("GBK");
                throw new ServiceException("[运行失败] " + errMessage);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();      // 一般不会执行这条, GBK肯定支持
            }
        }
        return false;   // 一般运行不到这一句
    }

    private void removeFile(String codeFileName) {
        try {
            Files.delete(Path.of(codeFileName + ".java"));
            Files.delete(Path.of(codeFileName + ".class"));
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }
    }

    /**
     * 设置submission错误原因
     */
    private Submission setSubmissionErrorType(Submission submission, String errorType) {
        submission.setIsSuccess(false);
        String[] errorTypes = errorType.split("已过时, 且标记为待删除");
        if (errorType.contains("已过时, 且标记为待删除") && errorTypes.length > 2) {
            errorType = errorType.split("已过时, 且标记为待删除")[2];
        }
        submission.setErrorType(errorType);
        return submission;
    }
}
