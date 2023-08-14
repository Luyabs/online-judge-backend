package com.example.onlinejudge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.common.util.RedisUtil;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemModifyVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(tags = "题目获取", value = "分页获取",
            notes = "参数: currentPage=当前页, pageSize=页大小, " +
                    "condition=条件查询{userId, title, content, type, difficulty, isVerified}")
    @GetMapping("/page")
    public Result getPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, ProblemQueryConditionVo condition) {
        IPage<ProblemDto> page = problemService.getPageDto(currentPage, pageSize, condition.setStatus(1));
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "题目获取", value = "分页获取(需管理员权限)",
            notes = "参数: currentPage=当前页, pageSize=页大小, " +
                    "condition=条件查询{userId, title, content, type, difficulty, isVerified}")
    @GetMapping("/admin/page")
    public Result getPageInAdmin(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, ProblemQueryConditionVo condition) {
        IPage<ProblemDto> page = problemService.getPageDtoInAdmin(currentPage, pageSize, condition);
        return Result.success().data("page", page);
    }

    @ApiOperation(tags = "题目获取", value = "按problemId获取（审核通过的题目）", notes = "参数: problemId=路径变量")
    @GetMapping("/{problemId}")
    public Result getById(@PathVariable(value = "problemId") String problemId) {
        if ("undefined".equals(problemId))
            throw new ServiceException("你需要指定problemId");
        Problem problem = problemService.getProblemById(Long.parseLong(problemId));
        return Result.success().data("problem", problem);
    }
    @ApiOperation(tags = "题目获取", value = "按problemId获取（任意状态的题目）", notes = "参数: problemId=路径变量")
    @GetMapping("/admin/{problemId}")
    public Result getByIdInAdmin(@PathVariable(value = "problemId") String problemId) {
        if ("undefined".equals(problemId))
            throw new ServiceException("你需要指定problemId");
        Problem problem = problemService.getProblemByIdInAdmin(Long.parseLong(problemId));
        return Result.success().data("problem", problem);
    }

    @ApiOperation(tags = "题目获取", value = "分页获取(我的上传)",
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
        if(problemId!=null){
            if(redisUtil.hasKey("problem:problemId:" +"::"+ problemModifyVo.getProblemId()))
                redisUtil.del("problem:problemId:" +"::"+ problemModifyVo.getProblemId());
            return Result.success().data("editProblemId", problemId).data("problemModifyVo",problemModifyVo);
        }
        else
            return Result.error();
    }

    @ApiOperation(tags = "上传管理", value = "删除题目",
            notes = "参数：题目Id")
    @DeleteMapping("/my_upload/{problemId}")
    public Result deleteProblem(@PathVariable Long problemId){
        boolean res = problemService.deleteProblem(problemId);
        if(res){
            if(redisUtil.hasKey("problem:problemId:" + "::"+ problemId))
                redisUtil.del("problem:problemId:" + "::"+ problemId);
            return Result.success().data("problemId", problemId);
        }
        else
            return Result.error();
    }

    /**
     * 这用于获取题目对应的测试用例
     */
    @ApiOperation(tags = "测试用例获取",value = "分页获取指定题目的测试用例",notes = "参数: problemId")
    @GetMapping("/page/test_case/{problemId}")
    public Result getPage(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize, @PathVariable(value = "problemId") long problemId) {
        IPage<TestCase> page = problemService.getTestCasePageByProblemId(problemId, currentPage, pageSize);
        return Result.success().data("page", page);
    }

}
