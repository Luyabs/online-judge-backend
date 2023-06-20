package com.example.onlinejudge.common.aop.authoritystrategy;

import com.example.onlinejudge.common.exception.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
    @Autowired
    private ProblemStrategy problemStrategy;

    @Autowired
    private TestCaseStrategy testCaseStrategy;

    public AuthorityStrategy factory(String methodName) {
        if (methodName.endsWith("Problem"))
            return problemStrategy;
        else if (methodName.endsWith("TestCase"))
            return testCaseStrategy;
        else
            throw new ServiceException("StrategyFactory中方法名" + methodName + "没有匹配项, 不能检查是否是作者");
    }
}
