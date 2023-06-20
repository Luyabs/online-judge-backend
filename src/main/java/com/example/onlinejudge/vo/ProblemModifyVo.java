package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProblemModifyVo extends ProblemInputVo{
    Long problemId;
}
