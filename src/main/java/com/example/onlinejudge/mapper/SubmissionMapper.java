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
            select
                IFNULL(SUM(CASE WHEN p.difficulty = 1 THEN 1 ELSE 0 END),0) AS easyCount,
                IFNULL(SUM(CASE WHEN p.difficulty = 2 THEN 1 ELSE 0 END),0) AS mediumCount,
                IFNULL(SUM(CASE WHEN p.difficulty = 3 THEN 1 ELSE 0 END),0) AS hardCount
            from problem p
            where p.problem_id in (
                select distinct p.problem_id from submission s
                    join problem p on p.problem_id = s.problem_id
                        where s.user_id = 1 and is_success = 1 and is_debug = 0);
            """)
    HashMap<String,Long> getProNumByDifficulty();

    @Select("""
            select
                IFNULL(SUM(CASE WHEN p.type = 1 THEN 1 ELSE 0 END),0) AS sqlCount,
                IFNULL(SUM(CASE WHEN p.type = 2 THEN 1 ELSE 0 END),0) AS javaCount
            from problem p
            where p.problem_id in (
                select distinct p.problem_id from submission s
                    join problem p on p.problem_id = s.problem_id
                        where s.user_id = 1 and is_success = 1 and is_debug = 0);
            """)
    HashMap<String,Long> getProNumByType();
}
