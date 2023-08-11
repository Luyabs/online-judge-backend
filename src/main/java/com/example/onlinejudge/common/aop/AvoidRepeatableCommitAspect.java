package com.example.onlinejudge.common.aop;

import com.example.onlinejudge.common.aop.annotation.AvoidRepeatableCommit;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Order(1)
@Aspect
@Component
public class AvoidRepeatableCommitAspect {
    @Autowired
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.example.onlinejudge.common.aop.annotation.AvoidRepeatableCommit)")
    private void idRepeat() {
        /*do nothing*/
    }
    @Before("idRepeat()")
    public void invoke(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String userId = String.valueOf(UserInfo.getUserId());
        String key = className +"::"+ userId;
        AvoidRepeatableCommit avoidRepeatableCommit =  method.getAnnotation(AvoidRepeatableCommit.class);
        long timeout = avoidRepeatableCommit.timeout();
        //使用lua脚本的方式
        if(redisUtil.hasKey(key)){
            NoAccessException.throwException("重复提交");
        }else {
            redisUtil.set(key, (Object) "uuid", timeout);
        }
    }

}
