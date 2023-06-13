package com.example.onlinejudge.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.onlinejudge.common.constant.Role;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.mapper.UserMapper;
import com.example.onlinejudge.service.UserService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public SaTokenInfo login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        User target = userMapper.selectOne(wrapper);

        if (target == null)
            throw new NotExistException("用户不存在");
        if (!password.equals(target.getPassword()))
            throw new NotExistException("密码不正确");

        StpUtil.login(target.getUserId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        tokenInfo.setTokenName("token");
        return tokenInfo;
    }

    @Override
    public Map<String, Object> info(String tokenValue) {
        long id =  Long.parseLong((String) StpUtil.getLoginIdByToken(tokenValue));
//        long id = StpUtil.getLoginIdAsLong();
        User user = userMapper.selectById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getUserId());
        map.put("name", user.getUsername());
        map.put("avatar", "https://panjiachen.gitee.io/vue-element-admin-site/home.png");
        map.put("roles", Role.getRole(user.getRole()).getRoleName());
        return map;
    }
}
