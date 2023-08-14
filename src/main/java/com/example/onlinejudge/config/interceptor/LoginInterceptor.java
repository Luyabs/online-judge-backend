package com.example.onlinejudge.config.interceptor;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setHeader("Access-Control-Allow-Origin", (request).getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //获取请求头中的token
        //两种键值对 key:token value: username
                 //key:username value: userInfo(token)
        String token = StpUtil.getTokenValue();
        log.error(token);
        if (redisUtil==null){
            //拦截器在bean初始化前执行的，这时候redisUtil是null，需要通过下面这个方式去获取
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtil = wac.getBean(RedisUtil.class);
        }
        //token不存在或不在redis中时返回错误信息
        if(StringUtils.isEmpty(token)|| !redisUtil.hasKey("sa-token:login:"+ token)){
            response.getWriter().write(JSONUtil.toJsonStr(Result.error().message("用户未登录，请进行登录").code(50008)));
            return false;
        }
        else if(redisUtil.hasKey("sa-token:login:"+ token)){
            //更新键值对存活时间
            String username = (String) redisUtil.get("sa-token:login:"+ token);
            redisUtil.expire("sa-token:login:"+ token,600);
            redisUtil.expire("userinfo:login:"+ username,6000);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
