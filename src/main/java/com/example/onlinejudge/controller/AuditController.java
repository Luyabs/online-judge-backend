package com.example.onlinejudge.controller;

import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.service.ProblemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-26 00:20:00
 */
@RestController
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    private ProblemService problemService;

    @ApiOperation(tags = "审核管理", value = "审核题目",
            notes = "参数：editRecordId, auditResult,verifyMessage")
    @PostMapping("/{editRecordId}")
    public Result auditProblem(@PathVariable(value = "editRecordId") Long editRecordId,
                               @RequestParam("auditResult") Boolean auditResult,
                               @RequestParam("verifyMessage") String verifyMessage){
        boolean res = problemService.auditProblem(editRecordId,auditResult,verifyMessage);
        return res?Result.success().data("problemId", editRecordId).data("auditResult",auditResult):Result.error();
    }
}
