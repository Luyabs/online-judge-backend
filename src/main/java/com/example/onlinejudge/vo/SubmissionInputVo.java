package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class SubmissionInputVo {

    @NotNull
    private Long problemId;

    @Max(2)
    @Min(1)
    @NotNull
    private Integer language;

    @NotNull
    private String code;

    private Boolean isDebug;


}
