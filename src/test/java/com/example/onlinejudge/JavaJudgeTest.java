package com.example.onlinejudge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
public class JavaJudgeTest {
    @Test
    void hotCompileTest() {
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
