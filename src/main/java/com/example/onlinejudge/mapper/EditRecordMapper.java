package com.example.onlinejudge.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.dto.EditRecordDto;
import com.example.onlinejudge.entity.EditRecord;
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
public interface EditRecordMapper extends BaseMapper<EditRecord> {
    @Select("""
            select e.*, p.title
            from edit_record e
            join problem p on e.original_problem_id = p.problem_id
            ${ew.customSqlSegment}
            """)
    IPage<EditRecordDto> selectPageDto(Page<Object> objectPage, @Param(Constants.WRAPPER) QueryWrapper<EditRecordDto> wrapper);

    @Select("""
            select e.*, p.problem_id, p.title
            from edit_record e
            join problem p on e.original_problem_id = p.problem_id
            where e.edit_record_id = #{edit_record_id}
            """)
    EditRecordDto selectByIdDto(@Param("edit_record_id") long editRecordId);


}
