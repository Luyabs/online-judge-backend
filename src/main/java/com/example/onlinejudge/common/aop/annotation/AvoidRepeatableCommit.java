package com.example.onlinejudge.common.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface  AvoidRepeatableCommit {
    long timeout()  default 3 ;
}
