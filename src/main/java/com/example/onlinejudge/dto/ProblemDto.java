package com.example.onlinejudge.dto;

import com.example.onlinejudge.entity.Problem;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProblemDto extends Problem {
    /**
     * 已完成状态(1: 未完成 2: 尝试中 3: 已完成)
     */
    private Integer hasDone;

    /**
     * 通过率
     */
    private Double passRate;

    /**
     * 标签
     */
    private List<String> tags = List.of("完成状态","标签" ,"题解都还没做");

    /**
     * 题解数
     */
    private Double solutionNum;
}
