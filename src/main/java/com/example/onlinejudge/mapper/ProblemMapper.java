package com.example.onlinejudge.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Mapper
public interface ProblemMapper extends BaseMapper<Problem> {
    // TODO: 多表查询 完成状态 题解数量 标签(@Many)
    @Select("""
            select
                p.*,
                (p.success_num / p.attempt_num) as passRate,
                1 as hasDone,
                -1 as solutionNum,
                null as tags
            from problem p
            join user s on p.user_id = s.user_id
            ${ew.customSqlSegment}
            """)
    IPage<ProblemDto> selectDtoPage(Page<ProblemDto> objectPage, @Param(Constants.WRAPPER) QueryWrapper<ProblemDto> wrapper);

}
