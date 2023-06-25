package com.example.onlinejudge.vo;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TestCaseModifyVo extends TestCaseInputVo{

    @NotBlank
    Long testCaseId;
}
