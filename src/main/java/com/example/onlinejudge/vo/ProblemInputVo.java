package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 上传题目所用VO
 */
@Data
@Accessors(chain = true)
public class ProblemInputVo {

    private String title;

    private String content;

    private Integer type;

    private Integer difficulty;

    private Double runtimeLimit;

    private Double memoryLimit;

}
