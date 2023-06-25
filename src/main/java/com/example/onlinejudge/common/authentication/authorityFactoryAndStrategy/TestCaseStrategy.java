package com.example.onlinejudge.common.authentication.authorityFactoryAndStrategy;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.service.TestCaseService;
import com.example.onlinejudge.vo.TestCaseModifyVo;
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
        else if (arg0.getClass() == TestCaseModifyVo.class)
            isOwner(((TestCaseModifyVo) arg0).getTestCaseId());
        else
            ServiceException.throwException("TestCaseStrategy中 " + arg0 + " 无法解析");
    }

    @Override
    public void isOwner(long testCaseId) {
        TestCase testCase = testCaseService.getByIdNotNull(testCaseId);
        Problem problem = problemService.getByIdNotNull(testCase.getProblemId());
        if (UserInfo.getUserId() != problem.getUserId())
            NoAccessException.throwException(testCaseId, "测试用例");
    }
}
