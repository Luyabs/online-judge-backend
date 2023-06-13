package com.example.onlinejudge.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("problem_tag")
public class ProblemTag {

    /**
     * 此关系的id
     */
    @TableId(value = "problem_tag_id", type = IdType.ASSIGN_ID)
    private Long problemTagId;

    /**
     * 题目id
     */
    private Long problemId;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 题目信息更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 题目新增时间
     */
    private LocalDateTime insertTime;
}
