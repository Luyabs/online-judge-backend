package com.example.onlinejudge.service.impl;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.EditAction;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.mapper.TestCaseMapper;
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
    private EditRecordMapper editRecordMapper;
    @Override
    @Transactional
    public boolean uploadTestCase(TestCaseInputVo testCaseInputVo) {
        TestCase testCase = new TestCase();
        BeanUtils.copyProperties(testCaseInputVo,testCase);
        //testCase.isverified默认为false
        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setOriginalProblemId(testCase.getProblemId()).
                setIsTestCase(true).
                setChangeAction(EditAction.INSERT.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        if(testCaseMapper.insert(testCase) == 1){
            newEditRecord.setOriginalTestCaseId(testCase.getTestCaseId());
            return editRecordMapper.insert(newEditRecord) == 1;
        }
        return false;
    }

    @Override
    public Long modifyTestCase(TestCaseModifyVo testCaseModifyVo) {

        return null;
    }

    @Override
    public boolean deleteTestCase(Long testCaseId) {
        TestCase testCase = testCaseMapper.selectById(testCaseId);
        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setOriginalProblemId(testCase.getProblemId()).
                setIsTestCase(true).
                setOriginalTestCaseId(testCaseId).
                setChangeAction(EditAction.DELETE.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        if(!testCase.getIsVerified())
            ServiceException.throwException("该状态（审核中）下用例无法删除");
        testCase.setIsVerified(false);
        return testCaseMapper.updateById(testCase) == 1&&editRecordMapper.insert(newEditRecord) == 1;
    }

    @Override
    public boolean auditTestCase(Long editRecordId, Boolean auditResult, String verifyMessage) {
        return false;
    }
}
