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
}
