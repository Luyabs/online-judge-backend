package com.example.onlinejudge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.base.BaseController;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.service.SubmissionService;
import com.example.onlinejudge.vo.SubmissionInputVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@RestController
@RequestMapping("/submission")
public class SubmissionController{


    @Autowired
    private SubmissionService submissionService;

    @ApiOperation(tags = "做题管理", value = "提交答案", notes = "参数：题目Id，代码语言，代码，是否调试")
    @PostMapping
    public Result uploadSubmission(@Valid @RequestBody SubmissionInputVo submissionInputVo){
        Submission sub = submissionService.uploadSubmission(submissionInputVo);
        return Result.success().data("submission", sub);
    }

    /**
     *
     * @param submissionId
     * @return submission
     */
    @ApiOperation(tags = "统计管理",value = "查询提交记录详情", notes = "参数：提交记录id")
    @GetMapping("/detail/{submissionId}")
    public Result getSubmission(@PathVariable(value = "submissionId") Long submissionId){
        Submission sub = submissionService.getSubmission(submissionId);
        return Result.success().data("submission", sub);
    }



}
