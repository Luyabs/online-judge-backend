package com.example.onlinejudge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.dto.StatisticsDto;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.judgebox.fascade.JudgeBox;
import com.example.onlinejudge.mapper.SubmissionMapper;
import com.example.onlinejudge.service.SubmissionService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.vo.SubmissionInputVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private SubmissionMapper submissionMapper;

    @Override
    public Submission uploadSubmission(SubmissionInputVo submissionInputVo) {
        Submission submission = new Submission().setUserId(UserInfo.getUserId());
        BeanUtils.copyProperties(submissionInputVo, submission);
        return judgeBox.judge(submission);
    }

    @Override
    @Authority(author = true, admin = true)
    public Submission getSubmission(Long submissionId) {
        return getByIdNotNull(submissionId);
    }


    @Override
    public IPage<Submission> getSubmissionPage(int currentPage, int pageSize) {
        QueryWrapper<Submission> wrapper = new QueryWrapper<Submission>().
                eq("user_id",UserInfo.getUserId()).
                orderByDesc("insert_time");
        return submissionMapper.selectPage(new Page<>(currentPage, pageSize), wrapper);
    }

    @Override
    public StatisticsDto getStatistics() {
        StatisticsDto statisticsDto = new StatisticsDto();
        QueryWrapper<Submission> wrapper;
        wrapper = new QueryWrapper<Submission>().eq("user_id",UserInfo.getUserId());
        statisticsDto.setTotalSubmissionCount(submissionMapper.selectCount(wrapper));

        wrapper.eq("is_success",true);
        statisticsDto.setPassedSubmissionCount(submissionMapper.selectCount(wrapper))
                .setTotalProblemCount(submissionMapper.getTotalProblemNumber(UserInfo.getUserId()))
                .setPassedProblemCount(submissionMapper.getPassedProblemNumber(UserInfo.getUserId()))
                .setProNumbyDiff(submissionMapper.getProNumByDifficulty()).
                setProNumbyType(submissionMapper.getProNumByType());
        return statisticsDto;
    }


}
