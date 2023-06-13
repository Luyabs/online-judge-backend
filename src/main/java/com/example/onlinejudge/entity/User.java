package com.example.onlinejudge.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user")
public class User {

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    /**
     * 权限
     */
    private Integer role;

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

    /**
     * 用户信息更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 用户加入时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime insertTime;
}
