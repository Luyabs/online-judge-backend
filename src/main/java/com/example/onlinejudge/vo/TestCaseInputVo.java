package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class TestCaseInputVo {
    @NotNull
    private Long problemId;

    private String input;

    private String output;  //考虑到输出可能为null,不做非空处理

    private String description;

    private Boolean isPrehandle;

    private Boolean isPosthandle;

    @Min(0)
    @Max(10)
    private Integer tOrder;


}
