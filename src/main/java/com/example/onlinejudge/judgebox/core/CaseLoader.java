package com.example.onlinejudge.judgebox.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.mapper.TestCaseMapper;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 测试用例读取器
 */
@Component
public class CaseLoader {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private TestCaseMapper testCaseMapper;

    /**
     * 校验problem是否存在
     * @return problemId
     */
    private long preCheckProblem(Submission submission) {
        if (submission.getProblemId() == null)
            NotExistException.throwException("submission缺失problemId属性");
        long problemId = submission.getProblemId();

        Problem problem = problemMapper.selectById(problemId);
        if (problem == null)
            NotExistException.throwException(problemId, "问题");
        if (problem.getStatus() != ProblemStatus.VERIFIED.index())
            ServiceException.throwException("id=" + problemId + "问题当前未审核通过");
        return problemId;
    }

    /**
     * 读取测试用例
     * @return 问题对应的测试用例
     */
    public List<TestCase> loadTestCase(Submission submission) {
        long problemId = preCheckProblem(submission);
        QueryWrapper<TestCase> wrapper = new QueryWrapper<TestCase>().eq("problem_id", problemId);
        List<TestCase> testCases = testCaseMapper.selectList(wrapper);
        if (testCases.isEmpty())
            NotExistException.throwException("本题没有可用测试用例");
        return testCases;
    }


}
