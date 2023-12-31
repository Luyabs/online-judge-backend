package com.example.onlinejudge.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 上传题目所用VO
 */
@Data
@Accessors(chain = true)
public class ProblemInputVo {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Max(2)
    @Min(1)
    @NotNull
    private Integer type;

    @Max(3)
    @Min(1)
    @NotNull
    private Integer difficulty;

    @DecimalMax(value = "4096.0")
    @DecimalMin(value = "256.0")
    private Double runtimeLimit;

    @DecimalMax(value = "4096.0")
    @DecimalMin(value = "256.0")
    private Double memoryLimit;

}
