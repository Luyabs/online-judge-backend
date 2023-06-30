package com.example.onlinejudge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.dto.StatisticsDto;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.common.base.BaseService;
import com.example.onlinejudge.vo.SubmissionInputVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
public interface SubmissionService extends BaseService<Submission> {

    Submission uploadSubmission(SubmissionInputVo submissionInputVo);

    Submission getSubmission(Long submissionId);

    IPage<Submission> getSubmissionPage(int currentPage, int pageSize);

    StatisticsDto getStatistics();
}
