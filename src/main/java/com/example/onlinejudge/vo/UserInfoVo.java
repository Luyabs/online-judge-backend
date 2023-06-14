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
public class UserInfoVo {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
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
     * 用户加入时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime insertTime;
}
