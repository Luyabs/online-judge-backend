package com.example.onlinejudge.mapper;

import com.example.onlinejudge.entity.Submission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Mapper
public interface SubmissionMapper extends BaseMapper<Submission> {


    @Select("select count(distinct problem_id) from submission where user_id = ${userId};")
    Long getTotalProblemNumber(@Param("userId") Long userId);

    @Select("select count(distinct problem_id) from submission where user_id = ${userId} and is_success = 1;")
    Long getPassedProblemNumber(@Param("userId") Long userId);
    @Select("""
            <script>
            select ;
            </script>
            """)
    HashMap<String,Integer> getProNumByDifficulty(List<Integer> difficultyList);

    @Select("""
            <script>
            select ;
            </script>
            """)
    HashMap<String,Integer> getProNumByType(List<Integer> typeList);
}
