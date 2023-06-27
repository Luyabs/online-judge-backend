package com.example.onlinejudge.judgebox.core;

import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.mapper.TestCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseLoader {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private TestCaseMapper testCaseMapper;

    private Problem loadProblem(Submission submission) {
        // TODO
        return null;
    }

    public List<TestCase> loadTestCase(Submission submission) {
        // TODO
        return null;
    }


}
