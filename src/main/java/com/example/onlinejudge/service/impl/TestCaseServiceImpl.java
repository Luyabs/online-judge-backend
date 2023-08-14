package com.example.onlinejudge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.aop.annotation.AvoidRepeatableCommit;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.EditAction;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.mapper.TestCaseMapper;
import com.example.onlinejudge.service.EditRecordService;
import com.example.onlinejudge.service.TestCaseService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.vo.TestCaseInputVo;
import com.example.onlinejudge.vo.TestCaseModifyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Service
public class TestCaseServiceImpl extends BaseServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {

    @Autowired
    private TestCaseMapper testCaseMapper;

    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private EditRecordService editRecordService;

    @Autowired
    private EditRecordMapper editRecordMapper;

    @Override
    @AvoidRepeatableCommit
    @Transactional
    public boolean uploadTestCase(TestCaseInputVo testCaseInputVo) {
        //防止重复提交
        Problem problem = problemMapper.selectById(testCaseInputVo.getProblemId());
        if(null == problem)
            NotExistException.throwException(testCaseInputVo.getProblemId(), "题目");
        if(problem.getStatus() != ProblemStatus.VERIFIED.index())
            ServiceException.throwException("题目未通过审核，无法提交用例");
        TestCase testCase = new TestCase();
        BeanUtils.copyProperties(testCaseInputVo,testCase);
        return testCaseMapper.insert(testCase) == 1;
    }

    @Override
    @Authority(author = true, admin = true)
    public boolean modifyTestCase(TestCaseModifyVo testCaseModifyVo) {
        TestCase originalTestCase = getByIdNotNull(testCaseModifyVo.getTestCaseId());
        testCaseModifyVo.setProblemId(null);                //不修改题目id
        BeanUtils.copyProperties(testCaseModifyVo,originalTestCase);
        return testCaseMapper.updateById(originalTestCase) == 1;
    }

    @Override
    @Authority(author = true, admin = true)
    public boolean deleteTestCase(Long testCaseId) {
        TestCase testCase = this.getByIdNotNull(testCaseId);
        return testCaseMapper.deleteById(testCaseId) == 1;
    }
}
