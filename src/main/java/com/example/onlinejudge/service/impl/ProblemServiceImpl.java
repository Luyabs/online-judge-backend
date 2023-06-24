package com.example.onlinejudge.service.impl;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.alibaba.druid.sql.visitor.functions.If;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.common.exception.handler.base.BaseServiceImpl;
import com.example.onlinejudge.constant.EditAction;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.constant.ProblemType;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.mapper.ProblemMapper;
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
    private EditRecordMapper editRecordMapper;

    @Override
    public IPage<ProblemDto> getPageDto(int currentPage, int pageSize, ProblemQueryConditionVo condition) {
        QueryWrapper<ProblemDto> wrapper = new QueryWrapper<ProblemDto>()
                .like(ObjectUtils.isNotEmpty(condition.getUserId()), "p.user_id", condition.getUserId())                             // 查询用户
                .like(ObjectUtils.isNotEmpty(condition.getTitle()), "title", condition.getTitle())                      // 查询标题
                .like(ObjectUtils.isNotEmpty(condition.getContent()), "content", condition.getContent())                // 查询内容
                .eq(ObjectUtils.isNotEmpty(condition.getType()), "type", condition.getType())                         // 查询类型
                .eq(ObjectUtils.isNotEmpty(condition.getDifficulty()), "difficulty", condition.getDifficulty())       // 查询难度
                .eq(ObjectUtils.isNotEmpty(condition.getStatus()), "status", condition.getStatus())      // 查询通过/未通过审核
                .orderByDesc("attempt_num");
        return problemMapper.selectDtoPage(new Page<>(currentPage, pageSize), wrapper);
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
                setIsTestCase(false).
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
        Problem oldProblem = problemMapper.selectById(problemModifyVo.getProblemId());
        int status = oldProblem.getStatus();
        if(status == ProblemStatus.VERIFYING.index()||status == ProblemStatus.HISTORY.index())
            ServiceException.throwException("该状态（审核中/历史）下题目无法修改");
        oldProblem.setStatus(ProblemStatus.HISTORY.index());        //旧数据设为“历史”状态

        Problem newProblem = new Problem()
                .setUserId(UserInfo.getUserId());
        BeanUtils.copyProperties(problemModifyVo,newProblem);
        newProblem.setProblemId(null).
                setStatus(ProblemStatus.VERIFYING.index());      //新数据设为“审核中”状态

        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setOriginalProblemId(oldProblem.getProblemId()).
                setIsTestCase(false).
                setChangeAction(EditAction.UPDATE.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        //修改旧数据状态同时插入新数据
        if(problemMapper.updateById(oldProblem) == 1&&problemMapper.insert(newProblem) == 1){
            newEditRecord.setEditProblemId(newProblem.getProblemId());
            //插入修改记录
            if(editRecordMapper.insert(newEditRecord) == 1)
                return newProblem.getProblemId();
        }
        return null;
    }

    @Override
    @Authority(author = true, admin = true)
    @Transactional
    public boolean deleteProblem(Long problemId) {
        EditRecord newEditRecord = new EditRecord().
                setUserId(UserInfo.getUserId()).
                setIsTestCase(false).
                setOriginalProblemId(problemId).
                setChangeAction(EditAction.DELETE.index()).
                setIsAdmin(UserInfo.isAdmin()).
                setStatus(EditStatus.WAIT.index());
        Problem oldProblem = problemMapper.selectById(problemId);
        int status = oldProblem.getStatus();
        if(status == ProblemStatus.VERIFYING.index()||status == ProblemStatus.HISTORY.index())
            ServiceException.throwException("该状态（审核中/历史）下题目无法删除");
        oldProblem.setStatus(ProblemStatus.VERIFYING.index());//只修改problem转态，删除操作留待管理员处理
        return problemMapper.updateById(oldProblem) == 1&&editRecordMapper.insert(newEditRecord) == 1;
    }

    @Override
    @Authority(author = false, admin = true)
    @Transactional
    public boolean auditProblem(Long editRecordId,Boolean auditResult ,String verifyMessage) {
        EditRecord editRecord = editRecordMapper.selectById(editRecordId);
        Problem problem = problemMapper.selectById(editRecord.getOriginalProblemId());
        if(editRecord.getStatus() != 1)
            ServiceException.throwException("修改记录状态不为‘审核中’");
        if(problem.getStatus() != ProblemStatus.VERIFYING.index())
            ServiceException.throwException("题目状态不为‘审核中’");
        editRecord.setVerifyMessage(verifyMessage);
        //修改修改记录状态
        boolean res;
        if(auditResult){                                                            //审核成功
            if(editRecord.getChangeAction() == EditAction.DELETE.index())           //删除数据
                res = problemMapper.deleteById(problem) == 1;
            editRecord.setStatus(EditStatus.VERIFIED.index());
            problem.setStatus(ProblemStatus.VERIFIED.index());
        }
        else{                                                                       //审核失败
            editRecord.setStatus(EditStatus.FAILED.index());
            problem.setStatus(ProblemStatus.FAILED.index());
        }
        return editRecordMapper.updateById(editRecord) == 1 && problemMapper.updateById(problem) == 1;

    }
}
