package com.example.onlinejudge.common.aop.authoritystrategy;

public interface AuthorityStrategy {
    /**
     * 执行策略
     * @param arg0 方法参数
     */
    void execute(Object arg0);

    /**
     * 判断是否为object的拥有者
     * @param objectId object的id
     */
    void isOwner(long objectId);
}
