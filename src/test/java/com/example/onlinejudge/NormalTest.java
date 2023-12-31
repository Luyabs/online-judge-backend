package com.example.onlinejudge;

import com.example.onlinejudge.common.authentication.StpRoleAndPermission;
import com.example.onlinejudge.common.exception.exception.ValidateException;
import com.example.onlinejudge.constant.ProblemDifficulty;
import com.example.onlinejudge.judgebox.fascade.JudgeBox;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

import static com.example.onlinejudge.common.exception.exception.ValidateException.NOT_NULL;
import static com.example.onlinejudge.common.exception.exception.ValidateException.UNIQUE;

@SpringBootTest
public class NormalTest {
    @Autowired
    StpRoleAndPermission stp;

    @Autowired
    JudgeBox judgeBox;


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
        int index = ProblemDifficulty.HARD.index();
        System.out.println(index);

        // 按序号 获取枚举对象 获取枚举对象的一个属性
        ProblemDifficulty difficulty = ProblemDifficulty.get(2);
        System.out.println(difficulty);
        System.out.println(difficulty.getDifficulty());
    }

    @Test
    void test03() {
        ValidateException.build()
                .ifC(1 == 2).throwE("1111=2222", NOT_NULL)
                .ifC(2 < 3).throwE("2<<<<3", UNIQUE);

        ValidateException.throwIf(1 == 2, "1111=2222", NOT_NULL);
        ValidateException.throwIf(2 < 3, "2<<<<3", UNIQUE);
    }

    @Test
    void test04() {
        new File("Java1234567890" + ".java").delete();

    }
}
