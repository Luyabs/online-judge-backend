package com.example.onlinejudge;

import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.judger.JavaJudge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootTest
public class JavaJudgeTest {
    @Autowired
    private JavaJudge javaJudge;
    @Test
    void testPreHandleCode() {
        Submission submission = new Submission()
                .setIsDebug(false)
//                .setSubmissionId(1234567890L)
                .setCode("""
                        public  class
                        HelloWorld {
                            // coding
                            public static int add(int a, int b, int c) {
                                return a + b + c;
                            }
                            
                            public static void main(String[] args) {
                                // get param from args
                                int a = Integer.parseI1nt(args[0]);
                                int b = Integer.parseInt(args[1]);
                                int c = Integer.parseInt(args[2]);
                                int res = add(a, b, c);
                                try {
                                Runtime.getRuntime().exec("ping baidu.com");
                                } catch (Exception e) {e.printStackTrace();}
                                System.out.println(res);
                            }
                        }
                        """);
        List<TestCase> testCases = List.of(
                new TestCase().setInput("1\n2\n3").setOutput("6"),
                new TestCase().setInput("4\n5\n6").setOutput("15"),
                new TestCase().setInput("7\n8\n9").setOutput("24")
        );
        javaJudge.judge(submission, testCases, new Problem());
        System.out.println(submission);
    }

    @Test
    void testPreHandleCode2() {
        Submission submission = new Submission()
                .setIsDebug(false)
                .setSubmissionId(1234567890L)
                .setCode("""
                        public  class HelloWorld {
                            public static String replaceWord(String str) {
                                return str.replace("a", "@");
                            }
                            
                            public static void main(String[] args) {
                                // get param from args
                                String str = args[0];
                                
                                String res = replaceWord(str);
                                System.out.println(res);
                            }
                        }
                        """);
        List<TestCase> testCases = List.of(
                new TestCase().setInput("abcdefa").setOutput("@bcdef@"),
                new TestCase().setInput("abstract").setOutput("@bstr@ct")
        );
        javaJudge.judge(submission, testCases, new Problem());
        System.out.println(submission);
    }

    @Test
    void compileTest() {
        String input = "Hello";
        String expectedOutput = "Hello, World!";

        // 读取用户提交的代码
        String userCode = getUserCode();

        // 将用户代码保存到文件中
        saveCodeToFile(userCode);

        // 编译用户代码
        boolean isCompilationSuccessful = compileUserCode();

        if (isCompilationSuccessful) {
            // 运行编译后的代码
            String actualOutput = runUserCode(input);

            System.out.println("output: " + actualOutput);
            // 比较输出结果
            if (expectedOutput.equals(actualOutput)) {
                System.out.println("代码通过测试！");
            } else {
                System.out.println("代码输出错误！");
            }
        } else {
            System.out.println("代码编译失败！");
        }
    }

    private static String getUserCode() {
        return """
               import java.util.*;

               class HelloWorld {
                   public static void main(String[] args) {
                       List<String> list = new ArrayList<>();
                       list.add("Hello, World!");
                       list.add("Hello, World!");
                       System.out.println(list);
                   }
               }
               """;
    }

    private static void saveCodeToFile(String code) {
        // 将代码保存到文件
        try (FileWriter fileWriter = new FileWriter("HelloWorld.java")) {
            fileWriter.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean compileUserCode() {
        // 使用Java编译器编译用户代码
        try {
            Process process = Runtime.getRuntime().exec("javac HelloWorld.java");
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String runUserCode(String input) {
        // 运行编译后的代码并获取输出
        try {
            Process process = Runtime.getRuntime().exec("java HelloWorld");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
