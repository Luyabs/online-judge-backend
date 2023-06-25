package com.example.onlinejudge.service;

import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.common.exception.handler.base.BaseService;
import com.example.onlinejudge.vo.ProblemModifyVo;
import com.example.onlinejudge.vo.TestCaseInputVo;
import com.example.onlinejudge.vo.TestCaseModifyVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
public interface TestCaseService extends BaseService<TestCase> {
    boolean uploadTestCase(TestCaseInputVo testCaseInputVo);

    Long modifyTestCase(TestCaseModifyVo testCaseModifyVo);

    boolean deleteTestCase(Long testCaseId);

    boolean auditTestCase(Long editRecordId,Boolean auditResult,String verifyMessage);
}
