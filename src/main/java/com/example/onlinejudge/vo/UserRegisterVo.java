package com.example.onlinejudge.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户基本信息VO
 */
@Data
@Accessors(chain = true)
public class UserRegisterVo {
    /**
     * 账户名
     */
    private String username;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个人简介
     */
    private String introduction;
}
