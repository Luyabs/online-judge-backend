package com.example.onlinejudge.common.exception.exception;

import java.io.Serializable;

/**
 * 自定义业务层异常类 - 不存在
 */
public class ValidateException extends ServiceException {
    /**
     * 异常信息
     * @param message 自定义异常信息
     */
    public ValidateException(String message){
        super(message);
    }

    /**
     * 快速生成异常信息
     * @param attribute 属性
     * @param reason 异常原因
     */
    public ValidateException(String attribute, String reason) {
        super(attribute + " " + reason);
    }

    public static void throwException(String message) {
        throw new ValidateException(message);
    }

    public static void throwException(String attribute, String reason) {
        throw new ValidateException(attribute, reason);
    }

    public static void throwIf(boolean condition, String message) {
        if (condition)
            throw new ValidateException(message);
    }

    public static void throwIf(boolean condition, String attribute, String reason) {
        if (condition)
            throw new ValidateException(attribute, reason);
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {
        private boolean condition;

        public Builder ifC(boolean condition) {
            this.condition = condition;
            return this;
        }

        public Builder throwE(String message) {
            throwIf(condition, message);
            condition = true;
            return this;
        }

        public Builder throwE(String attribute, String reason) {
            throwIf(condition, attribute, reason);
            condition = true;
            return this;
        }

        public Builder build() {
            return new Builder();
        }
    }
}
