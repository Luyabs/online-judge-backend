package com.example.onlinejudge.dto;

import com.example.onlinejudge.entity.pojo.ProNumByDifficulty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;

@Data
@Accessors(chain = true)
public class StatisticsDto {

    /**
     * 总提交次数
     */
    private Long totalSubmissionNumber;

    /**
     * 通过的提交数
     */
    private Long passedSubmissionNumber;

    /**
     * 完成的题目数量
     */
    private Long passedProblemNumber;

    /**
     * 题目总数
     */
    private Long totalProblemNumber;

    /**
     * 通过的题目数量（按难度分属性）
     */
    private HashMap<String,Integer> ProNumDiff;

    /**
     * 通过的题目数量（按题目类型分属性）
     */
    private HashMap<String,Integer> ProNumType;

}
