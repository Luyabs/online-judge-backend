package com.example.onlinejudge.common.authentication;

import cn.dev33.satoken.stp.StpUtil;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.Role;

import java.util.List;

public class UserInfo {

    /**
     * 是否登录
     * @return 登录 / 未登录
     */
    public static boolean isLogin() {
        return StpUtil.isLogin();
    }

    /**
     * 是否管理员
     * @return 管理 / 普通用户
     */
    public static boolean isAdmin() {
        return StpUtil.hasRole(Role.ADMIN.getRoleName());
    }

    /**
     * 获取用户id  (未登录报错)
     * @return 用户id
     */
    public static long getUserId() {
        proveLogin();
        return StpUtil.getLoginIdAsLong(); //Long.parseLong(String.valueOf(StpUtil.getLoginId()));
    }

    /**
     * 获取用户角色 (保证单一角色)
     * @return role (int)
     */
    public static int getRoleNumberSingle() {
        proveLogin();
        List<Integer> roleList = new StpRoleAndPermission().getRoleNumList(getUserId());
        if (roleList.size() != 1)
            throw new ServiceException("角色数量只能为1");
        return roleList.get(0);
    }

    /**
     * 获取用户角色 (保证单一角色)
     * @return role (String)
     */
    public static String getRoleNameSingle() {
        proveLogin();
        List<String> roleList = new StpRoleAndPermission().getRoleList(getUserId(), null);
        if (roleList.size() != 1)
            throw new ServiceException("角色数量只能为1");
        return roleList.get(0);
    }

    /**
     * 保证处于登录状态
     */
    private static void proveLogin() {
        if (!StpUtil.isLogin())
            NotExistException.throwException("用户未登录");
    }
}
