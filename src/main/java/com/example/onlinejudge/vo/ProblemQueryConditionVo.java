package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 条件查询所用VO
 */
@Data
@Accessors(chain = true)
public class ProblemQueryConditionVo {
    /**
     * 作者id
     */
    private Long userId;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题目类型
     */
    private Integer type;

    /**
     * 难度
     */
    private Integer difficulty;

    /**
     * 是否通过审核
     */
    private Boolean isVerified;
}
