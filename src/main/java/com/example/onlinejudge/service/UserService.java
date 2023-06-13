package com.example.onlinejudge.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.common.base.BaseService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
public interface UserService extends BaseService<User> {
    SaTokenInfo login(String username, String password);

    Map<String, Object> info(String tokenValue);
}
