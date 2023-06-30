package com.example.onlinejudge.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;

@Data
@Accessors(chain = true)
public class StatisticsDto {

    /**
     * 总提交次数
     */
    private Long totalSubmissionCount;

    /**
     * 通过的提交数
     */
    private Long passedSubmissionCount;

    /**
     * 通过的题目数量
     */
    private Long passedProblemCount;

    /**
     * 做过的题目总数
     */
    private Long totalProblemCount;

    /**
     * 通过的题目数量（按难度分属性）
     */
    private HashMap<String,Long> ProNumbyDiff;

    /**
     * 通过的题目数量（按题目类型分属性）
     */
    private HashMap<String,Long> ProNumbyType;

}
