package com.example.onlinejudge.judgebox.core.security;


import java.security.Permission;
import java.util.List;

public class JavaJudgeSecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        // 在这里可以添加自定义的权限检查逻辑
        throw new SecurityException("访问被禁止");
    }

    public static void main(String[] args) {

        System.out.println("程序开始执行");
        try {
            int count = 0;
            for (int e : List.of(1, 2, 3, 4, 5)) {
                count += e;
            }
            // 触发权限检查
//            Process process = Runtime.getRuntime().exec("ping baidu.com");
            System.exit(0);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("程序继续执行");
    }
}
