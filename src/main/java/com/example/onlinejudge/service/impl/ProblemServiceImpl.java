package com.example.onlinejudge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.constant.EditAction;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.mapper.TestCaseMapper;
import com.example.onlinejudge.service.EditRecordService;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemModifyVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;
import org.apache.commons.lang3.ObjectUtils;
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
public class ProblemServiceImpl extends BaseServiceImpl<ProblemMapper, Problem> implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private EditRecordService editRecordService;

    @Autowired
    private EditRecordMapper editRecordMapper;

    @Autowired
    private TestCaseMapper testCaseMapper;

    @Override
    public IPage<ProblemDto> getPageDto(int currentPage, int pageSize, ProblemQueryConditionVo condition) {
        QueryWrapper<ProblemDto> wrapper = new QueryWrapper<ProblemDto>()
                .like(ObjectUtils.isNotEmpty(condition.getUserId()), "p.user_id", condition.getUserId())                             // 查询用户
                .like(ObjectUtils.isNotEmpty(condition.getTitle()), "title", condition.getTitle())                      // 查询标题
                .like(ObjectUtils.isNotEmpty(condition.getContent()), "content", condition.getContent())                // 查询内容
                .eq(ObjectUtils.isNotEmpty(condition.getType()), "type", condition.getType())                         // 查询类型
                .eq(ObjectUtils.isNotEmpty(condition.getDifficulty()), "difficulty", condition.getDifficulty())       // 查询难度
                .eq(ObjectUtils.isNotEmpty(condition.getStatus()), "status", condition.getStatus())      // 查询通过/未通过审核
                .ne("status", ProblemStatus.HISTORY.index())      // 不该查历史记录
                .orderByAsc("p.problem_id");
        return problemMapper.selectDtoPage(new Page<>(currentPage, pageSize), wrapper);
    }

    @Override
    @Authority(author = false, admin = true)
    public IPage<ProblemDto> getPageDtoInAdmin(int currentPage, int pageSize, ProblemQueryConditionVo condition) {
        return this.getPageDto(currentPage, pageSize, condition);
    }

    @Override
    @Transactional
    public boolean uploadProblem(ProblemInputVo problemInputVo) {
        Problem newProblem = new Problem().
                setUserId(UserInfo.getUserId()).
                setStatus(ProblemStatus.VERIFYING.index());
        BeanUtils.copyProperties(problemInputVo,newProblem);
        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setChangeAction(EditAction.INSERT.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        if(problemMapper.insert(newProblem) == 1){
            newEditRecord.setOriginalProblemId(newProblem.getProblemId());
            return  editRecordMapper.insert(newEditRecord) == 1;
        }
        return false;

    }

    @Override
    @Authority(author = true, admin = true)
    @Transactional
    public Long modifyProblem(ProblemModifyVo problemModifyVo) {
        Problem originalProblem = this.getByIdNotNull(problemModifyVo.getProblemId());
        int status = originalProblem.getStatus();
        if(status == ProblemStatus.VERIFYING.index()||status == ProblemStatus.HISTORY.index())
            ServiceException.throwException("该状态（审核中/历史）下题目无法修改");
        Problem editProblem = new Problem();
        BeanUtils.copyProperties(originalProblem,editProblem);                          //复制为临时
        editProblem.setProblemId(null).setStatus(ProblemStatus.HISTORY.index());        //旧数据设为“历史”状态

        BeanUtils.copyProperties(problemModifyVo,originalProblem);       //修改原id下数据为新数据
        originalProblem.setStatus(ProblemStatus.VERIFYING.index());      //新数据设为“审核中”状态

        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setOriginalProblemId(originalProblem.getProblemId()).
                setChangeAction(EditAction.UPDATE.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        //修改旧数据状态同时插入新数据
        if(problemMapper.updateById(originalProblem) == 1&&problemMapper.insert(editProblem) == 1){
            newEditRecord.setEditProblemId(editProblem.getProblemId());
            //插入修改记录
            if(editRecordService.save(newEditRecord))
                return editProblem.getProblemId();
        }
        return null;
    }

    @Override
    @Authority(author = true, admin = true)
    @Transactional
    public boolean deleteProblem(Long problemId) {
        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setOriginalProblemId(problemId).
                setChangeAction(EditAction.DELETE.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        Problem oldProblem = this.getByIdNotNull(problemId);
        int status = oldProblem.getStatus();
        if(status == ProblemStatus.VERIFYING.index()||status == ProblemStatus.HISTORY.index())
            ServiceException.throwException("该状态（审核中/历史）下题目无法删除");
        oldProblem.setStatus(ProblemStatus.VERIFYING.index());//只修改problem转态，删除操作留待管理员处理
        return problemMapper.updateById(oldProblem) == 1 && editRecordMapper.insert(newEditRecord) == 1;
    }

    @Override
    @Authority(author = false, admin = true)
    @Transactional
    public boolean auditProblem(Long editRecordId,Boolean auditResult ,String verifyMessage) {
        EditRecord editRecord = editRecordService.getByIdNotNull(editRecordId);
        Problem newProblem = getByIdNotNull(editRecord.getOriginalProblemId());

        //判断修改记录状态是否为“审核中”
        if(editRecord.getStatus() != 1)
            ServiceException.throwException("修改记录状态不为‘审核中’");
        editRecord.setVerifyMessage(verifyMessage);

        //判断题目状态是否为“审核中”
        Integer editAction = editRecord.getChangeAction();
        boolean res = true;
        if(newProblem.getStatus() != ProblemStatus.VERIFYING.index())
            ServiceException.throwException("题目状态不为‘审核中’");
        if(auditResult){
            if(editAction == EditAction.DELETE.index())                             //删除数据
                res = problemMapper.deleteById(newProblem) == 1;
            editRecord.setStatus(EditStatus.VERIFIED.index());
            newProblem.setStatus(ProblemStatus.VERIFIED.index());
        }
        else{
            editRecord.setStatus(EditStatus.FAILED.index());
            newProblem.setStatus(ProblemStatus.FAILED.index());
        }

        return res && editRecordMapper.updateById(editRecord) == 1
                && problemMapper.updateById(newProblem) == 1;

    }


    @Override
    @Authority(author = true, admin = true)
    public IPage<TestCase> getTestCasePageByProblemId(long problemId, int currentPage, int pageSize) {
        return testCaseMapper.selectPage(
                new Page<>(currentPage, pageSize),
                new QueryWrapper<TestCase>().eq("problem_id", problemId)
                        .orderByDesc("is_prehandle")
                        .orderByDesc("is_posthandle")
                        .orderByDesc("t_order")
                        .orderByDesc("update_time")
        );
    }
}
