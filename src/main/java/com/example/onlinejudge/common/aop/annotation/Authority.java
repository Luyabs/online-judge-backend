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
    boolean author() default true;      // 开启后，需要作者权限才能访问

    boolean admin() default true;      // 开启后，需要管理员权限才能访问

    // 上述两个权限若都为true 满足其一即可 若都为false则相当于不起作用
}
