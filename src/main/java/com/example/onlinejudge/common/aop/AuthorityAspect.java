package com.example.onlinejudge.common.aop;

import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.mapper.ProblemMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Aspect
@Component
public class AuthorityAspect {
    @Autowired
    private ProblemMapper problemMapper;

    @Pointcut("@annotation(com.example.onlinejudge.common.aop.annotation.Authority)")
    private void authorityJudge() {
        /*do nothing*/
    }

    @Before("authorityJudge()")
    public void invoke(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
        Authority authority = methodSignature.getMethod().getAnnotation(Authority.class);

        if (null != authority) {
            if (authority.admin() && UserInfo.isAdmin()) {    // 允许管理员
                return;
            }
//            if (authority.author()) {   // 允许题目作者
//                switch (authority.clazz()) {
//                    case Problem.class -> {
//                        problemMapper.selectOne(new QueryWrapper<Problem>()
//                                .eq("user_id", UserInfo.getUserId())
//                        );
//
//                    }
//                }
//                return;
//            }
            NoAccessException.throwException("无权访问(需要admin)");   // 抛出异常
        }
    }
}
