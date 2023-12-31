package com.example.onlinejudge.common.aop;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Order(1)
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.onlinejudge.service.*Service.*(..))")   // @annotation(Log)
    private void printLogMethod() {
        /*do nothing*/
    }

    @Before("printLogMethod()")
    public void invoke(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String now = LocalDateTime.now().toString().split("\\.")[0];
        if (StpUtil.isLogin()) {
            long userId = StpUtil.getLoginIdAsLong();
            log.info(now + "\t"
                    + "user_id=" + userId + "\t"
                    + joinPoint.getTarget().getClass().getName() + "\t"
                    + methodSignature.getMethod().getName() + "\t"
                    + Arrays.asList(joinPoint.getArgs()));
        }
        else {
            log.info(now + "\t"
                    + "__guest__" + "\t"
                    + joinPoint.getTarget().getClass().getName() + "\t"
                    + methodSignature.getMethod().getName() + "\t"
                    + Arrays.asList(joinPoint.getArgs()));
        }
    }
}
