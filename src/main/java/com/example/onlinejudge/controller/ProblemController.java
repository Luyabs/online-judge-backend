package com.example.onlinejudge.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.dto.ProblemDto;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.vo.ProblemInputVo;
import com.example.onlinejudge.vo.ProblemQueryConditionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.net.PortUnreachableException;

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
        IPage<ProblemDto> page = problemService.getPageDto(currentPage, pageSize, condition.setIsVerified(true));
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
        IPage<ProblemDto> page = problemService.getPageDto(currentPage, pageSize, condition.setUserId(StpUtil.getLoginIdAsLong()));
        return Result.success().data("page", page);
    }
    @ApiOperation(tags = "上传管理",value = "上传题目",
    notes = "参数: title, content, type, difficulty,runtime_limit,memory_limit")
    @PostMapping("/my_upload")
    public Result upLoadProblem(@RequestBody ProblemInputVo problemInputVo){
        boolean res = problemService.upLoadProblem(problemInputVo);
        return res?Result.success().data("problemInputVo", problemInputVo):Result.error();
    }
}
