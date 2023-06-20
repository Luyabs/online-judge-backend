package com.example.onlinejudge.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.Role;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.mapper.UserMapper;
import com.example.onlinejudge.service.UserService;
import com.example.onlinejudge.vo.UserInfoVo;
import com.example.onlinejudge.vo.UserLoginVo;
import com.example.onlinejudge.vo.UserRegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

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

    /**
     * 用户登录
     * @param userLoginVo 登录VO {username, password}
     */
    @Override
    public SaTokenInfo login(UserLoginVo userLoginVo) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", userLoginVo.getUsername());
        User target = userMapper.selectOne(wrapper);

        if (target == null)
            throw new NotExistException("用户不存在");
        if (!userLoginVo.getPassword().equals(target.getPassword()))
            throw new NotExistException("密码不正确");

        StpUtil.login(target.getUserId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        tokenInfo.setTokenName("token");
        return tokenInfo;
    }

    /**
     * 解析token
     * 需注意: 此处并非根据header中的token做解析
     * @param tokenValue token值
     */
    @Override
    public UserInfoVo info(String tokenValue) {
        long id =  Long.parseLong((String) StpUtil.getLoginIdByToken(tokenValue));
//        long id = StpUtil.getLoginIdAsLong();
        User user = getByIdNotNull(id);         // 由BaseService提供的方法
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);     // 将user的属性赋值给vo
        userInfoVo.setRoles(Collections.singletonList(Role.get(user.getRole()).getRoleName()));    // 将role属性从int转到List<String>
        return userInfoVo;
    }

    /**
     * 注册
     * @param userRegisterVo 登录VO {username, password, nickname, introduction}
     */
    @Override
    public boolean register(UserRegisterVo userRegisterVo) {
        User user = new User().setRole(Role.NORMAL_USER.index());
        BeanUtils.copyProperties(userRegisterVo, user);
        if (user.getPassword().length() < 6)
            throw new ServiceException("密码长度需要大于6位");
        return userMapper.insert(user) > 0;
    }
}
