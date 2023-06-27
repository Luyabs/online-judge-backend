package com.example.onlinejudge.judgebox.core;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.judger.Judge;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JudgeCore {
    // TODO: judger

    private Judge judgeFactory(Submission submission) {
        // TODO
        return null;
    }

    public Submission judge(Submission submission, List<TestCase> testCases) {
        // TODO
        return null;
    }
}
