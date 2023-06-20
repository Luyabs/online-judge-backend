package com.example.onlinejudge.common.aop;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemModifyVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Aspect
@Component
public class ProblemServiceAspect {
    @Autowired
    private ProblemService problemService;

    @Pointcut("execution(* com.example.onlinejudge.service.ProblemService.modifyProblem(..))" +
            "|| execution(* com.example.onlinejudge.service.ProblemService.deleteProblem(..))")
    private void ownerPointCut() {
        /*do nothing*/
    }

    /**
     * 检验用户是否拥有对题目的修改删除权
     */
    @Before("ownerPointCut()")
    private void ownerInvoke(JoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        if (arg != null) {
            if (arg.getClass() == Long.class)
                judgeOwnerOrAdmin((Long) arg);
            if (arg.getClass() == ProblemModifyVo.class)
                judgeOwnerOrAdmin(((ProblemModifyVo) arg).getProblemId());
        }
    }

    /**
     * 判断当前用户是否为题目的创作者或管理员
     * @param problemId
     */
    private void judgeOwnerOrAdmin(long problemId) {
        Problem problem = problemService.getByIdNotNull(problemId);
        if (!UserInfo.isAdmin() && UserInfo.getUserId() != problem.getUserId())
            NoAccessException.throwException(problemId, "问题");
    }
}
