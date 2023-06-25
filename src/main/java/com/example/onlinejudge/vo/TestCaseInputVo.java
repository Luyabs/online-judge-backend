package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TestCaseInputVo {

    @NotBlank
    private Long problemId;

    @NotBlank
    private String input;

    private String output;  //考虑到输出可能为null,不做非空处理

    private String description;

    private Boolean isPrehandle;

    private Boolean isPosthandle;

    @Min(0)
    private Integer order;


}
