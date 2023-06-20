package com.example.onlinejudge.common.aop;

import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Aspect
@Component
public class AuthorityAspect {

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
            NoAccessException.throwException("无权访问(需要admin)");   // 抛出异常
        }
    }
}
