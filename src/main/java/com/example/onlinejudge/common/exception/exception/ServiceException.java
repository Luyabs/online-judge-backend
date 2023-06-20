package com.example.onlinejudge.common.exception.exception;

/**
 * 自定义业务层异常类 - 通用业务异常
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message){
        super(message);
    }

    public static void throwException(String message) {
        throw new ServiceException(message);
    }

    public static void throwIf(boolean condition, String message) {
        if (condition)
            throw new ServiceException(message);
    }

}
