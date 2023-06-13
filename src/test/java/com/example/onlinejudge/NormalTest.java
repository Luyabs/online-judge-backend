package com.example.onlinejudge;

import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.authentication.StpRoleAndPermission;
import com.example.onlinejudge.common.constant.ProblemDifficulty;
import com.example.onlinejudge.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NormalTest {
    @Autowired
    StpRoleAndPermission stp;

    @Test
    void test01() {
        List<String> roleList = stp.getRoleList(1, null);
        System.out.println(roleList);

        roleList = stp.getRoleList(2, null);
        System.out.println(roleList);
    }

    @Test
    void test02() {
        // 获取枚举量索引
        int index = ProblemDifficulty.getIndex(ProblemDifficulty.HARD);
        System.out.println(index);

        // 按序号 获取枚举对象 获取枚举对象的一个属性
        ProblemDifficulty difficulty = ProblemDifficulty.getProblemDifficulty(2);
        System.out.println(difficulty);
        System.out.println(difficulty.getRoleName());
    }
}
