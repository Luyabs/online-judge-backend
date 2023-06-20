package com.example.onlinejudge.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.base.BaseController;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.service.UserService;
import com.example.onlinejudge.vo.UserInfoVo;
import com.example.onlinejudge.vo.UserLoginVo;
import com.example.onlinejudge.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    @Autowired
    private UserService userService;

    @ApiOperation(tags = "登录注册管理", value = "登录", notes = "传入username和password")
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginVo userLoginVo) {
        SaTokenInfo token = userService.login(userLoginVo);
        return Result.success().data("token", token.getTokenValue());
    }

    @ApiOperation(tags = "登录注册管理", value = "解析token", notes = "需传入token")
    @GetMapping("/info")
    public Result getInfo(@RequestParam("token") String tokenValue) {
        UserInfoVo userInfoVo = userService.info(tokenValue);
        return Result.success().data("user", userInfoVo);
    }

    @ApiOperation(tags = "登录注册管理", value = "登出")
    @PostMapping("/logout")
    public Result logout() {
        StpUtil.logout();
        return Result.success().message("登出成功");
    }

    @ApiOperation(tags = "登录注册管理", value = "注册")
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterVo userRegisterVo) {
        boolean res = userService.register(userRegisterVo);
        return res ? Result.success().message("注册成功") : Result.error();
    }

    @ApiOperation(tags = "登录注册管理", value = "是否登录")
    @GetMapping("/is_login")
    public Result isLogin() {
        return StpUtil.isLogin() ? Result.success().data("id", StpUtil.getLoginId()) : Result.error().message("未登录");
    }
}
