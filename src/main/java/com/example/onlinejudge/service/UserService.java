package com.example.onlinejudge.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.common.base.BaseService;
import com.example.onlinejudge.vo.UserInfoVo;
import com.example.onlinejudge.vo.UserLoginVo;
import com.example.onlinejudge.vo.UserRegisterVo;

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
    SaTokenInfo login(UserLoginVo userLoginVo);

    UserInfoVo info(String tokenValue);

    boolean register(UserRegisterVo userRegisterVo);
}
