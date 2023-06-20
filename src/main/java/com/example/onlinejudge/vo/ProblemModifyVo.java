package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class ProblemModifyVo extends ProblemInputVo{
    @NotNull
    Long problemId;
}
