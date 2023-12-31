package com.example.onlinejudge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.common.base.BaseService;
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

    boolean modifyTestCase(TestCaseModifyVo testCaseModifyVo);

    boolean deleteTestCase(Long testCaseId);
}
