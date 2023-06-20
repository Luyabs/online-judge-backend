package com.example.onlinejudge.common.exception.exception;

import java.io.Serializable;

/**
 * 自定义业务层异常类 - 不存在
 */
public class NotExistException extends ServiceException {
    /**
     * 异常信息
     * @param message 自定义异常信息
     */
    public NotExistException(String message){
        super(message);
    }

    /**
     * 快速生成异常信息
     * @param id id值 (通常是主键)
     * @param attribute 属性 / 对象名
     */
    public NotExistException(Serializable id, String attribute) {
        super("不存在 id=" + id + " 的 " + attribute);
    }

    public static void throwException(String message) {
        throw new NotExistException(message);
    }

    public static void throwException(Serializable id, String attribute) {
        throw new NotExistException(id, attribute);
    }

    public static void throwIf(boolean condition, String message) {
        if (condition)
            throw new NotExistException(message);
    }

    public static void throwIf(boolean condition, Serializable id, String attribute) {
        if (condition)
            throw new NotExistException(id, attribute);
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

        public Builder throwE(Serializable id, String attribute) {
            throwIf(condition, id, attribute);
            condition = true;
            return this;
        }

        public Builder build() {
            return new Builder();
        }
    }
}
