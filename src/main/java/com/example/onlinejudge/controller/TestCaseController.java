package com.example.onlinejudge.controller;

import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.exception.handler.base.BaseController;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.service.TestCaseService;
import com.example.onlinejudge.vo.TestCaseInputVo;
import com.example.onlinejudge.vo.TestCaseModifyVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@RestController
@RequestMapping("/testCase")
public class TestCaseController extends BaseController<TestCase> {
    @Autowired
    private TestCaseService testCaseService;

    @ApiOperation(tags = "上传管理",value = "上传测试用例",notes = "参数: testCaseInputVo")
    @PostMapping
    public Result uploadTestCase(@RequestBody TestCaseInputVo testCaseInputVo){
        boolean res = testCaseService.uploadTestCase(testCaseInputVo);
        return res?Result.success().data("testCaseInputVo", testCaseInputVo):Result.error();
    }

    @ApiOperation(tags = "上传管理",value = "修改测试用例",notes = "参数: testCaseModifyVo")
    @PutMapping
    public Result modifyTestCase(@RequestBody TestCaseModifyVo testCaseModifyVo){
        Long testCaseId = testCaseService.modifyTestCase(testCaseModifyVo);
        return testCaseId != null?
                Result.success().data("newTestCaseID", testCaseId).data("testCaseModifyVo",testCaseModifyVo): Result.error();
    }
    @ApiOperation(tags = "上传管理", value = "删除测试用例",
            notes = "参数：用例Id")
    @DeleteMapping("/{testCaseId}")
    public Result deleteTestCase(@PathVariable Long testCaseId){
        boolean res = testCaseService.deleteTestCase(testCaseId);
        return res?Result.success().data("testCaseId", testCaseId):Result.error();
    }

}
