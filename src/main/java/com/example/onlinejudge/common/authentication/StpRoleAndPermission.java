package com.example.onlinejudge.common.authentication;

import cn.dev33.satoken.stp.StpInterface;
import com.example.onlinejudge.common.constant.Role;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpRoleAndPermission implements StpInterface {
    @Autowired
    private UserService userService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 不用permission
        return List.of("*");
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        User user = userService.getByIdNotNull((Serializable) loginId);
        list.add(Role.getRole(user.getRole()).getRoleName());
        return list;
    }
}
