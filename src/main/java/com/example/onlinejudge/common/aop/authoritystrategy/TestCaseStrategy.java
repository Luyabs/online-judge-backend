package com.example.onlinejudge.common.aop.authoritystrategy;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.service.TestCaseService;
import com.example.onlinejudge.vo.ProblemModifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestCaseStrategy implements AuthorityStrategy {
    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private ProblemService problemService;

    @Override
    public void execute(Object arg0) {
        if (arg0.getClass() == Long.class)
            isOwner((Long) arg0);
        if (arg0.getClass() == ProblemModifyVo.class)
            isOwner(((ProblemModifyVo) arg0).getProblemId());
    }

    @Override
    public void isOwner(long testCaseId) {
        TestCase testCase = testCaseService.getByIdNotNull(testCaseId);
        Problem problem = problemService.getByIdNotNull(testCase.getProblemId());
        if (UserInfo.getUserId() != problem.getUserId())
            NoAccessException.throwException(testCaseId, "测试用例");
    }
}
