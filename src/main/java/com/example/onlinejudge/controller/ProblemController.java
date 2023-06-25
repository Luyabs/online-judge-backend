package com.example.onlinejudge.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemModifyVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;
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
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @ApiOperation(tags = "题目获取", value = "分页获取",
            notes = "参数: currentPage=当前页, pageSize=页大小, " +
                    "condition=条件查询{userId, title, content, type, difficulty, isVerified}")
    @GetMapping("/page")
    public Result getPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, ProblemQueryConditionVo condition) {
        IPage<ProblemDto> page = problemService.getPageDto(currentPage, pageSize, condition.setStatus(1));
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "题目获取", value = "按problemId获取", notes = "参数: problemId=路径变量")
    @GetMapping("/{problemId}")
    public Result getById(@PathVariable(value = "problemId") String problemId) {
        if ("undefined".equals(problemId))
            throw new ServiceException("你需要指定problemId");
        Problem problem = problemService.getByIdNotNull(Long.parseLong(problemId));
        return Result.success().data("problem", problem);
    }

    @ApiOperation(tags = "上传管理", value = "分页获取",
            notes = "参数: currentPage=当前页, pageSize=页大小, " +
                    "condition=条件查询{userId, title, content, type, difficulty, isVerified}")
    @GetMapping("/my_upload")
    public Result getMyUploadPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, ProblemQueryConditionVo condition) {
        IPage<ProblemDto> page = problemService.getPageDto(currentPage, pageSize, condition.setUserId(UserInfo.getUserId()));
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "上传管理",value = "上传题目",
    notes = "参数: title, content, type, difficulty,runtime_limit,memory_limit")
    @PostMapping("/my_upload")
    public Result upLoadProblem(@Valid @RequestBody ProblemInputVo problemInputVo){
        boolean res = problemService.uploadProblem(problemInputVo);
        return res?Result.success().data("problemInputVo", problemInputVo):Result.error();
    }

    @ApiOperation(tags = "上传管理", value = "修改题目",
            notes = "参数: problemId, title, content, type, difficulty,runtime_limit,memory_limit")
    @PutMapping("/my_upload")
    public Result modifyProblem(@Valid @RequestBody ProblemModifyVo problemModifyVo) {
        Long problemId = problemService.modifyProblem(problemModifyVo);
        return problemId!=null?Result.success().data("newProblemId", problemId).data("problemModifyVo",problemModifyVo):Result.error();
    }

    @ApiOperation(tags = "上传管理", value = "删除题目",
            notes = "参数：题目Id")
    @DeleteMapping("/my_upload/{problemId}")
    public Result deleteProblem(@PathVariable Long problemId){
        boolean res = problemService.deleteProblem(problemId);
        return res?Result.success().data("problemId", problemId):Result.error();
    }

    @ApiOperation(tags = "审核管理", value = "审核题目",
            notes = "参数：editRecordId, auditResult,verifyMessage")
    @PostMapping("/audit/{editRecordId}")
    public Result auditProblem(@PathVariable(value = "editRecordId") Long editRecordId,
                               @RequestParam("auditResult") Boolean auditResult,
                                @RequestParam("verifyMessage") String verifyMessage){
        boolean res = problemService.auditProblem(editRecordId,auditResult,verifyMessage);
        return res?Result.success().data("problemId", editRecordId).data("auditResult",auditResult):Result.error();
    }


}
