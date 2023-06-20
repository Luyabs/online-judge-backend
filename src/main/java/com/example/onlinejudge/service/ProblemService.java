package com.example.onlinejudge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.common.base.BaseService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemModifyVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
public interface ProblemService extends BaseService<Problem> {

    IPage<ProblemDto> getPageDto(int currentPage, int pageSize, ProblemQueryConditionVo condition);

    boolean upLoadProblem(ProblemInputVo problemInputVo);

    boolean modifyProblem(ProblemModifyVo problemModifyVo);

    boolean deleteProblem(Long problenId);

}
