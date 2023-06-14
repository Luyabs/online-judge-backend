package com.example.onlinejudge.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登录与注册VO
 */
@Data
@Accessors(chain = true)
public class UserLoginVo {
    /**
     * 账户名
     */
    private String username;

    /**
     * 用户登录密码
     */
    private String password;
}
