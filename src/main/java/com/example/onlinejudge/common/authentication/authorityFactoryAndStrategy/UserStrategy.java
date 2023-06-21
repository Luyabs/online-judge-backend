package com.example.onlinejudge.common.authentication.authorityFactoryAndStrategy;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.entity.User;
import com.example.onlinejudge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStrategy implements AuthorityStrategy {
    @Autowired
    private UserService userService;

    @Override
    public void execute(Object arg0) {
        if (arg0.getClass() == Long.class)
            isOwner((Long) arg0);
//        else if (arg0.getClass() == ProblemModifyVo.class)
//            isOwner(((ProblemModifyVo) arg0).getProblemId());
        else
            ServiceException.throwException("ProblemStrategy中 " + arg0 + " 无法解析");
    }

    @Override
    public void isOwner(long userId) {
        User user = userService.getByIdNotNull(userId);
        if (UserInfo.getUserId() != user.getUserId())
            NoAccessException.throwException(userId, "用户");
    }
}
