package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户基本信息VO
 */
@Data
@Accessors(chain = true)
public class UserQueryConditionVo {
    /**
     * 账户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个人简介
     */
    private String introduction;

    /**
     * 是否被封禁
     */
    private Boolean isBanned;
}
