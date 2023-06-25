package com.example.onlinejudge.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.service.EditRecordService;
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

    @Autowired
    private EditRecordService editRecordService;

    @ApiOperation(tags = "审核管理",value = "分页获取待审核的更改申请",notes = "[不区分问题与用例] 参数: currentPage=当前页, pageSize=页大小")
    @GetMapping("/page")
    public Result getPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize) {
        IPage<EditRecord> page = editRecordService.getPage(currentPage, pageSize, EditStatus.WAIT);
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "审核管理",value = "按id获取更改申请",notes = "[不区分问题与用例] 参数: testCaseId")
    @GetMapping("/{editRecordId}")
    public Result getById(@PathVariable(value = "editRecordId") long editRecordId) {
        EditRecord editRecord = editRecordService.getByIdNotNull(editRecordId);
        return Result.success().data("editRecord", editRecord);
    }

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
