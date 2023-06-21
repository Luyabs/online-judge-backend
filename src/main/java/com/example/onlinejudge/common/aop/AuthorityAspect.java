package com.example.onlinejudge.common.aop;

import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.authorityFactoryAndStrategy.AuthorityStrategy;
import com.example.onlinejudge.common.authentication.authorityFactoryAndStrategy.StrategyFactory;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
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
    private StrategyFactory strategyFactory;


    @Pointcut("@annotation(com.example.onlinejudge.common.aop.annotation.Authority)")
    private void authorityJudge() {
        /*do nothing*/
    }

    @Before("authorityJudge()")
    public void invoke(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Authority annotation = methodSignature.getMethod().getAnnotation(Authority.class);

        if (null != annotation && (annotation.admin() || annotation.author())) {    // 注解存在，且至少需要管理员或作者一个权限
            if (annotation.admin() && UserInfo.isAdmin())    // 允许管理员访问
                return;
            if (annotation.author()) {  // 允许作者访问
                String className = joinPoint.getTarget().getClass().getSimpleName();  // 注解所在的类方法名
                AuthorityStrategy strategy = strategyFactory.factory(className); // 判断作者策略
                Object arg0 = joinPoint.getArgs()[0];   // 首个参数
                if (arg0 != null) {
                    strategy.execute(arg0);
                    return;
                }
            }
            NoAccessException.throwException("无权访问");
        }
    }
}
