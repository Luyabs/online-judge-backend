package com.example.onlinejudge.common.aop.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解@CheckAuthority
 * 用于将来可能使用的额外权限校验 (如所有权)
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {
    boolean author() default true;      // 作者权限 -- 暂时无用

    boolean admin() default true;      // 管理员权限
}
