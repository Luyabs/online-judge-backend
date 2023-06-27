package com.example.onlinejudge.judgebox.core.judger;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;

import java.util.List;

/**
 * 判题接口
 */
public interface Judge {
    Submission judge(Submission submission, List<TestCase> testCases);
}
