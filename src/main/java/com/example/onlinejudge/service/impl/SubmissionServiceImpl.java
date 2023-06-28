package com.example.onlinejudge.service.impl;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.judgebox.fascade.JudgeBox;
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
    private JudgeBox judgeBox;

    @Override
    public Submission uploadSubmission(SubmissionInputVo submissionInputVo) {
        Submission submission = new Submission().setUserId(UserInfo.getUserId());
        BeanUtils.copyProperties(submissionInputVo, submission);
        return judgeBox.judge(submission);
    }
}
