package com.example.onlinejudge;

import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NormalTest {
    @Autowired
    private UserController userController;

    @Test
    void test01() {
        Result result = userController.getById(111);
        System.out.println(result);
    }
}
