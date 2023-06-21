package com.example.onlinejudge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.aop.annotation.Authority;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemModifyVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;
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
public class ProblemServiceImpl extends BaseServiceImpl<ProblemMapper, Problem> implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public IPage<ProblemDto> getPageDto(int currentPage, int pageSize, ProblemQueryConditionVo condition) {
        QueryWrapper<ProblemDto> wrapper = new QueryWrapper<ProblemDto>()
                .like(condition.getUserId() != null, "p.user_id", condition.getUserId())                             // 查询用户
                .like(condition.getTitle() != null, "title", condition.getTitle())                      // 查询标题
                .like(condition.getContent() != null, "content", condition.getContent())                // 查询内容
                .eq(condition.getType() != null, "type", condition.getType())                         // 查询类型
                .eq(condition.getDifficulty() != null, "difficulty", condition.getDifficulty())       // 查询难度
                .eq(condition.getStatus() != null, "status", condition.getStatus());      // 查询通过/未通过审核
        return problemMapper.selectDtoPage(new Page<>(currentPage, pageSize), wrapper);
    }

    @Override
    public boolean uploadProblem(ProblemInputVo problemInputVo) {
        Problem newProblem = new Problem().setUserId(UserInfo.getUserId());
        BeanUtils.copyProperties(problemInputVo,newProblem);
        return problemMapper.insert(newProblem) == 1;
    }

    @Override
    @Authority(author = true, admin = true)
    public boolean modifyProblem(ProblemModifyVo problemModifyVo) {
        Problem newProblem = new Problem()
                .setUserId(UserInfo.getUserId())
                .setProblemId(problemModifyVo.getProblemId());
        BeanUtils.copyProperties(problemModifyVo,newProblem);
        return problemMapper.updateById(newProblem) == 1;
    }

    @Override
    @Authority(author = true, admin = true)
    public boolean deleteProblem(Long problemId) {
        return problemMapper.deleteById(problemId) == 1;
    }
}
