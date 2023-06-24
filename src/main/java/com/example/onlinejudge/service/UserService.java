package com.example.onlinejudge.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.common.exception.handler.base.BaseService;
import com.example.onlinejudge.vo.*;

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

    IPage<User> getPage(int currentPage, int pageSize, UserQueryConditionVo condition);

    boolean reverseIsBanned(Long userId);
}
