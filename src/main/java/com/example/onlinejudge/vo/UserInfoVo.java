package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户基本信息VO
 * 仅为token解析服务
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色
     */
    private List<String> roles;

    /**
     * 头像
     */
    private String avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";

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

    /**
     * 用户加入时间
     */
    private LocalDateTime insertTime;

    /**
     * 信息更新时间
     */
    private LocalDateTime updateTime;
}
