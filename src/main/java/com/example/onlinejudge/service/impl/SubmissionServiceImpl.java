package com.example.onlinejudge.service.impl;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.mapper.SubmissionMapper;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.service.SubmissionService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.vo.SubmissionInputVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Service
public class SubmissionServiceImpl extends BaseServiceImpl<SubmissionMapper, Submission> implements SubmissionService {

    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private ProblemService problemService;
    @Override
    public boolean uploadSubmission(SubmissionInputVo submissionInputVo) {
        Problem problem = problemService.getByIdNotNull(submissionInputVo.getProblemId());
        if(problem.getStatus() != ProblemStatus.VERIFIED.index())
            ServiceException.throwException("该题目状态未审核通过，无法做题");

        /**目前只有sql和java两种类型，如若新增语言需要修改
         */
        if(!Objects.equals(problem.getType(), submissionInputVo.getLanguage()))
            ServiceException.throwException("代码语言不符合题目要求");
        Submission newSubmission = new Submission().setUserId(UserInfo.getUserId());
        BeanUtils.copyProperties(submissionInputVo,newSubmission);
        return submissionMapper.insert(newSubmission) == 1;
    }
}
