package com.example.onlinejudge.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.ProblemDifficulty;
import com.example.onlinejudge.constant.ProblemType;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;
import org.apache.commons.lang3.StringUtils;
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
                .eq(condition.getIsVerified() != null, "is_verified", condition.getIsVerified());      // 查询通过/未通过审核
        return problemMapper.selectDtoPage(new Page<>(currentPage, pageSize), wrapper);
    }

    @Override
    public boolean upLoadProblem(ProblemInputVo problemInputVo) {
        if(StringUtils.isBlank(problemInputVo.getTitle()))
            throw new ServiceException("题目标题不能为空");
        if(StringUtils.isBlank(problemInputVo.getContent()))
            throw new ServiceException("题目内容不能为空");
        if(ProblemType.get(problemInputVo.getType()) == ProblemType.NULL)
            throw new ServiceException("题目类型不存在");
        if(ProblemDifficulty.get(problemInputVo.getDifficulty()) == ProblemDifficulty.NULL)
            throw new ServiceException("题目难度不存在");
        if(problemInputVo.getRuntimeLimit() < 0||problemInputVo.getRuntimeLimit() > 128)
            throw new ServiceException("时间限制超范围");
        if(problemInputVo.getMemoryLimit() < 0||problemInputVo.getMemoryLimit() > 128)
            throw new ServiceException("内存限制超范围");
        Problem newProblem = new Problem().setUserId(Long.valueOf(String.valueOf(StpUtil.getLoginId())));
        BeanUtils.copyProperties(problemInputVo,newProblem);
        problemMapper.insert(newProblem);
        return true;
    }
}
