package com.example.onlinejudge.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.util.RedisUtil;
import com.example.onlinejudge.dto.StatisticsDto;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.service.SubmissionService;
import com.example.onlinejudge.service.UserService;
import com.example.onlinejudge.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

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
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(tags = "登录注册管理", value = "登录", notes = "传入username和password")
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginVo userLoginVo) {
        SaTokenInfo new_token = userService.login(userLoginVo);
        if(redisUtil.hasKey("userinfo:login:"+ userLoginVo.getUsername())){
            String token = (String) redisUtil.get("userinfo:login:"+ userLoginVo.getUsername());
            redisUtil.del("sa-token:login:"+ token);
            redisUtil.del("userinfo:login:"+ userLoginVo.getUsername());
        }
        //key-value: token(String)-username(String)
        redisUtil.set("sa-token:login:"+ new_token.tokenValue,userLoginVo.getUsername(),3600);
        //key-value: username(String)-satoken(String)
        redisUtil.set("userinfo:login:"+ userLoginVo.getUsername(),new_token.tokenValue,3600);
        return Result.success().data("token", new_token.getTokenValue());
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
        String userName = userService.getById(UserInfo.getUserId()).getUsername();
        if(redisUtil.hasKey("userinfo:login:"+ userName)){
            String token = (String) redisUtil.get("userinfo:login:"+ userName);
            redisUtil.del("sa-token:login:"+ token);
            redisUtil.del("userinfo:login:"+ userName);
        }
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
        String userName = userService.getById(UserInfo.getUserId()).getUsername();

        return redisUtil.hasKey("userinfo:login:"+ userName) && StpUtil.isLogin() ?
                Result.success().data("id", StpUtil.getLoginId()) : Result.error().message("未登录");
    }

    @ApiOperation(tags = "用户信息管理", value = "分页获取",
            notes = "参数: currentPage=当前页, pageSize=页大小, " +
                    "condition=条件查询{username, nickname, introduction, isBanned}")
    @GetMapping("/page")
    public Result getPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, UserQueryConditionVo condition) {
        IPage<User> page = userService.getPage(currentPage, pageSize, condition);
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "用户信息管理", value = "按problemId获取", notes = "参数: userId=路径变量")
    @GetMapping("/{userId}")
    public Result getById(@PathVariable(value = "userId") Long userId) {
        User user = userService.getByIdNotNull(userId);
        return Result.success().data("user", user);
    }

    @ApiOperation(tags = "用户信息管理", value = "封禁/解除封禁", notes = "参数: userId=路径变量, 反置isBanned属性")
    @PostMapping("/ban/{userId}")
    public Result reverseIsBanned(@PathVariable(value = "userId") Long userId) {
        boolean res = userService.reverseIsBanned(userId);
        return res ? Result.success().message("封禁状态调整成功") : Result.error();
    }

    @ApiOperation(tags = "统计管理",value = "查询用户提交历史", notes = "参数：页索引，页大小")
    @GetMapping("/submission")
    public Result getSubmissionHistory(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize){
        IPage<Submission> page= submissionService.getSubmissionPage(currentPage,pageSize);
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "统计管理",value = "查询用户做题数据", notes = "参数：无")
    @GetMapping("/statistic")
    public Result getStatistics(){
        StatisticsDto statisticsDto = submissionService.getStatistics();
        return Result.success().data("statistic", statisticsDto);
    }
}
