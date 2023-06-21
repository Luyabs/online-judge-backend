package com.example.onlinejudge.common.authentication.authorityFactoryAndStrategy;

import com.example.onlinejudge.common.exception.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
    @Autowired
    private ProblemStrategy problemStrategy;

    @Autowired
    private TestCaseStrategy testCaseStrategy;

    @Autowired
    private UserStrategy userStrategy;

    public AuthorityStrategy factory(String className) {
        className = className.substring(0, className.lastIndexOf("ServiceImpl"));
        return switch (className) {
            case "Problem" -> problemStrategy;
            case "TestCase" -> testCaseStrategy;
            case "User" -> userStrategy;
            default -> throw new ServiceException("StrategyFactory中方法名" + className + "没有匹配项, 不能检查是否是作者");
        };
    }
}
