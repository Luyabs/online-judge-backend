package com.example.onlinejudge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.common.base.BaseService;
import com.example.onlinejudge.entity.TestCase;
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

    Problem getProblemById(Long problemId);
    IPage<ProblemDto> getPageDtoInAdmin(int currentPage, int pageSize, ProblemQueryConditionVo condition);


    boolean uploadProblem(ProblemInputVo problemInputVo);

    /**
     *
     * @param problemModifyVo
     * @return Long editProblemID 旧数据（临时数据）的id
     */
    Long modifyProblem(ProblemModifyVo problemModifyVo);

    boolean deleteProblem(Long problemId);

    /**
     *
     * @param editRecordId     修改记录ID
     * @param auditResult       审核结果
     * @return  boolean
     */
    boolean auditProblem(Long editRecordId,Boolean auditResult,String verifyMessage);

    /**
     * 获取一个题目的所有测试用例
     */
    IPage<TestCase> getTestCasePageByProblemId(long problemId ,int currentPage, int pageSize);

}
