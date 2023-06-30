package com.example.onlinejudge.judgebox.core.judger;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Java判题机
 */
@Component
public class JavaJudge implements Judge {
    @Override
    public Submission judge(Submission submission, List<TestCase> testCases, double runTimeLimit) {
        // TODO

        return null;
    }

    private String preHandleCode(String code) {
        // TODO: 将用户代码更换类名
        // TODO: 我的想法：用户不能import任何包（均预先指定可引入的包名），用户提交的代码都会放进一个class内
        return null;
    }
}
