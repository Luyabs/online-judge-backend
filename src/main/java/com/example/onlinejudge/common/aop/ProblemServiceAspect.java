package com.example.onlinejudge.common.aop;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.common.exception.exception.ValidateException;
import com.example.onlinejudge.constant.ProblemDifficulty;
import com.example.onlinejudge.constant.ProblemType;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemModifyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.example.onlinejudge.common.exception.exception.ValidateException.*;

@Slf4j
@Order(1)
@Aspect
@Component
public class ProblemServiceAspect {
    @Autowired
    private ProblemService problemService;

    @Pointcut("execution(* com.example.onlinejudge.service.ProblemService.*Problem(..))")
    private void voValidPointCut() {
        /*do nothing*/
    }

    @Pointcut("execution(* com.example.onlinejudge.service.ProblemService.modifyProblem(..))" +
            "|| execution(* com.example.onlinejudge.service.ProblemService.deleteProblem(..))")
    private void ownerPointCut() {
        /*do nothing*/
    }

    /**
     * 校验VO字段属性
     */
    @Before("voValidPointCut()")
    public void voInvoke(JoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        if (arg != null && arg.getClass() == ProblemInputVo.class) {
            judgeProblemContent(arg);
        }
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
     * 校验VO字段属性
     * @param problemVo
     */
    private void judgeProblemContent(Object problemVo) {
        Problem problem = new Problem();
        BeanUtils.copyProperties(problemVo, problem);

        ValidateException.build()
                .ifC(StringUtils.isBlank(problem.getTitle())).throwE("题目标题", NOT_NULL)
                .ifC(StringUtils.isBlank(problem.getContent())).throwE("题目内容", NOT_NULL)
                .ifC(problem.getType() == ProblemType.NULL.index()).throwE("题目类型", NOT_EXIST)
                .ifC(problem.getDifficulty() == ProblemDifficulty.NULL.index()).throwE("题目难度", NOT_EXIST)
                .ifC(problem.getRuntimeLimit() < 0 || problem.getRuntimeLimit() > 128).throwE("时间限制", OUT_OF_RANGE)
                .ifC(problem.getMemoryLimit() < 0 || problem.getMemoryLimit() > 128).throwE("内存限制", OUT_OF_RANGE);
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
