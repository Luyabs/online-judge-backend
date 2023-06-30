package com.example.onlinejudge.judgebox.core.judger;

import com.example.onlinejudge.common.JdbcTemplateBean;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.List;

/**
 * Mysql判题机
 */
@Component
public class MysqlJudge implements Judge {
    private enum Type {
        DQL,
        DML,
        DDL,
        NULL
    }
    @Autowired
    private JdbcTemplateBean jdbcTemplateBean;

    /**
     * 外观判断方法，只允许外部类调用此方法
     */
    @Override
    public Submission judge(Submission submission, List<TestCase> testCases, Problem problemLimitCase) {
        double runTimeLimit = 1024, memoryLimit = 0;        // 暂时没用上memoryLimit
        if (problemLimitCase.getRuntimeLimit() != null && problemLimitCase.getRuntimeLimit() >= 1024)
            runTimeLimit = problemLimitCase.getRuntimeLimit();        String code = submission.getCode().trim().toLowerCase();
        if (code.split(";").length > 1) {
            return setSubmissionErrorType(submission, "在SQL题中你只能提交一句输入");
        }

        Type type = getCodeType(code);
        if (type != Type.DQL && type != Type.DML) {
            return setSubmissionErrorType(submission, "只允许提交DQL与DML语句");
        }

        boolean hasCheckedCodeTime = false;     // 是否已经测过用户提交的代码运行速度
        int passNum = 0;    // 通过测试用例个数
        int preOrPostHandleNum = 0;  // 前置或后置处理用例个数
        boolean testResult = true;   // 是否到目前为止与预期输出结果完全匹配
        synchronized (this) {   // 远程执行SQL必须独占
            for (TestCase testCase: testCases) {
                // 根据不同的回答类型 做不同判断处理
                try {
                    if (!testResult && !testCase.getIsPosthandle()) { // 如果出现wrong answer，则停止执行output，直接执行后置处理语句
                        continue;
                    }
                    executeTestCaseInputCode(testCase); // 先执行测试用例的输入 (只允许 空/DDL/DML)
                    if (testCase.getIsPrehandle() || testCase.getIsPosthandle()) {
                        preOrPostHandleNum++;  // 前后置处理语句 不需要执行output
                        continue;
                    }
                    else if (!hasCheckedCodeTime) { // 还没测过速 且不是前后置语句
                        // 运行一遍 以统计SQL时间 同时如果超时则杀死执行进程 正常情况下返回运算时间
                        double time = queryTimeCalculating(code, runTimeLimit);
                        submission.setRuntime(time);
                        hasCheckedCodeTime = true;
                    }
                    // 执行output
                    testResult = (type == Type.DQL) ? executeDqlTestCaseOutputCode(submission, testCase) : executeDmlTestCaseOutputCode(submission, testCase);
                    passNum += testResult ? 1 : 0;  // 测试用例通过则增加通过数
                    if (submission.getIsDebug()) { // 如果是调试则只运行一个非pre/post用例就停止
                        break;
                    }
                } catch (BadSqlGrammarException ex) {   // 抛掷的异常 都在这转给submission
                    String exMessage = ex.getMessage();
                    if (!StringUtils.isBlank(exMessage) && exMessage.startsWith("PreparedStatementCallback; bad SQL grammar")) {
                        return setSubmissionErrorType(submission,"语法错误: " + exMessage.split("PreparedStatementCallback;")[1]);
                    }
                    return setSubmissionErrorType(submission,exMessage);
                } catch (ServiceException ex) {
                    return setSubmissionErrorType(submission, ex.getMessage());
                }
            }
        }
        submission.setPassTestCaseNum(passNum); // 设置通过数量结果
        int validCaseNum = testCases.size() - preOrPostHandleNum;   // 纳入计算的用例数
        validCaseNum = submission.getIsDebug() ? 1 : validCaseNum;  // 调试只运行一个非pre/post用例
        if (passNum == validCaseNum || (passNum == 1 && submission.getIsDebug())) {   // 通过所有用例 调试只运行一个非pre/post用例
            return submission.setIsSuccess(true);
        } else {
            return setSubmissionErrorType(submission,
                    "Wrong Answer (passed: " + passNum + "/" + validCaseNum + ")");
        }
    }

    /**
     * 测试问题 输入
     */
    private void executeTestCaseInputCode(TestCase testCase) {
        // 先执行测试用例的输入 (只允许 空/DDL/DML)
        String inputSentences = testCase.getInput().toLowerCase();
        for (String input : inputSentences.split(";")) {
            if (!StringUtils.isBlank(input)) {
                switch (getCodeType(input)) {
                    case DDL -> jdbcTemplateBean.execute(input);
                    case DML -> jdbcTemplateBean.update(input);
                    default -> ServiceException.throwException("[测试用例异常] 该INPUT语句应为 空/DDL/DML");
                }
            }
        }
    }

    /**
     * 测试类型为DQL的问题 输出
     * @param testCase input: DML(多句), output: DQL(单句) (若为pre/posthandle 则input: DDL(多句) output: null)
     */
    private boolean executeDqlTestCaseOutputCode(Submission submission, TestCase testCase) {
        String code = submission.getCode().toLowerCase();
        // 执行用户代码 和 output中的select语句
        String output = testCase.getOutput();
        if (getCodeType(output) != Type.DQL) {
            return false;
        }
        // 判断结果是否正确
        List<List<Object>> submissionAnswer = jdbcTemplateBean.query(code);
        List<List<Object>> trueAnswer = jdbcTemplateBean.query(output);
        StringBuilder codeResult = new StringBuilder();
        for (List<Object> list : submissionAnswer) {
            for (Object object : list) {
                codeResult.append(object).append("\t");
            }
            codeResult.append("\n");
        }
        submission.setCodeResult(codeResult.toString());     // 设置判断结果
        return submissionAnswer.equals(trueAnswer);
    }

    /**
     * 测试类型为DML的问题 输出
     * @param testCase input: null, output: int(表示修改行行数) (若为pre/posthandle 则input: DDL(多句) output: null)
     */
    private boolean executeDmlTestCaseOutputCode(Submission submission, TestCase testCase) {
        String code = submission.getCode().toLowerCase();
        // 执行用户代码 和 output中的select语句
        String output = testCase.getOutput();
        if (getCodeType(output) != Type.DML) {
            return false;
        }
        // 判断结果是否正确
        int submissionAnswer = jdbcTemplateBean.update(code);
        submission.setCodeResult("影响行数: " + submissionAnswer);     // 设置判断结果
        return submissionAnswer == Integer.parseInt(output);
    }

    /**
     * 根据句首判断是DQL DML DDL
     */
    private Type getCodeType(String code) {
        if (StringUtils.isBlank(code))
            return Type.NULL;
        code = code.trim().toLowerCase();
        if (code.startsWith("select"))
            return Type.DQL;
        else if (code.startsWith("update") || code.startsWith("insert") || code.startsWith("delete") || code.startsWith("truncate table"))
            return Type.DML;
        else if (code.startsWith("create table") || code.startsWith("drop table"))
            return Type.DDL;
        else
            return Type.NULL;
    }

    /**
     * 设置submission错误原因
     */
    private Submission setSubmissionErrorType(Submission submission, String errorType) {
        submission.setIsSuccess(false);
        submission.setErrorType(errorType);
        return submission;
    }

    /**
     * 获取开始时间 (已补偿网络时延 (ms级精度))
     */
    private long getStartTimeWithoutNetWorkLag() {
        long lag;
        try {
            String targetDatabase = jdbcTemplateBean.getUrl().split("//")[1].split(":")[0];
            InetAddress address = InetAddress.getByName(targetDatabase);
            long startPingTime = System.currentTimeMillis();
            boolean isReachable = address.isReachable(5000); // 设置超时时间为5秒
            if (!isReachable)
                throw new ServiceException("无法连接到数据库");
            lag = System.currentTimeMillis() - startPingTime;
//            System.out.println("lag: " +lag);
        } catch (Exception ex) {
            // 此方法可能会因超时被打断
            ex.printStackTrace();
            throw new ServiceException(ex.getMessage());
        }
        return lag + System.currentTimeMillis();     // 现在时间 + 网络时延
    }

    /**
     * 运行时间统计
     * 会通过新线程执行一遍最基础的SQL，如果超时则杀死该线程
     */
    private double queryTimeCalculating(String sql, double runTimeLimit) {
        final double[] executeTime = {-1.0};
        final Object lock = new Object();   // 一把用来同步的锁

        Thread queryThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    jdbcTemplateBean.execute("select 1");
                    double startTime = System.nanoTime();
                    jdbcTemplateBean.execute(sql);
                    executeTime[0] = System.nanoTime() - startTime;
                } catch (Exception ex) {
                    // 执行sql语句的异常(非超时)
                    throw new ServiceException(ex.getMessage());
                } finally {
                    lock.notify(); // 唤醒等待的主线程
                }
            }
        });

        try {
            queryThread.start();
        } catch (ServiceException ex) {
            throw new ServiceException(ex.getMessage());    // 将非超时异常传递给上层
        }

        synchronized (lock) {
            try {
                lock.wait((long) runTimeLimit); // 主线程等待，超时时间为runTimeLimit
                if (queryThread.isAlive()) {
                    queryThread.interrupt();    // query线程仍在运行则打断
                    throw new ServiceException("运行超时 Runtime Limit: " + runTimeLimit + " ms");
                }
            } catch (InterruptedException ex) {
                // 中断异常处理
                ex.printStackTrace();
            }
        }

        return executeTime[0] / 1000000;
    }
}
