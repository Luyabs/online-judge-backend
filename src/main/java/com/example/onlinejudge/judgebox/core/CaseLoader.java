package com.example.onlinejudge.judgebox.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.ProblemStatus;
import com.example.onlinejudge.constant.ProblemType;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.mapper.ProblemMapper;
import com.example.onlinejudge.mapper.TestCaseMapper;
import com.example.onlinejudge.service.ProblemService;
import com.example.onlinejudge.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 测试用例读取器 <br/>
 * 负责从问题、用例存在性等方面检验提交是否合法 <br/>
 * 当判断非法时，将会以异常形式进行返回，不会在数据库中留下记录 <br/>
 * <u> 一般情况下用户正常在浏览器提交的代码不会产生这里的异常 </u> <br/>
 * 当判断均通过时，将读取并输出问题所需的测试用例(已排序) <br/>
 */
@Component
public class CaseLoader {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private TestCaseMapper testCaseMapper;

    /**
     * 校验problem是否存在
     * @return problemId
     */
    private Problem preCheckProblem(Submission submission) {
        if (submission.getProblemId() == null)
            NotExistException.throwException("submission缺失problemId属性");
        long problemId = submission.getProblemId();

        Problem problem = problemMapper.selectById(problemId);
        if (problem == null)
            NotExistException.throwException(problemId, "问题");
        if (problem.getStatus() != ProblemStatus.VERIFIED.index())      // 确保问题审核通过
            ServiceException.throwException("id=" + problemId + "问题当前未审核通过");
        return problem;
    }

    /**
     * 读取测试用例
     * @return 问题对应的测试用例
     */
    public List<TestCase> loadTestCase(Submission submission) {
        Problem problem = preCheckProblem(submission);
        QueryWrapper<TestCase> wrapper = new QueryWrapper<TestCase>().eq("problem_id", problem.getProblemId());
        List<TestCase> testCases = testCaseMapper.selectList(wrapper);
        if (testCases.isEmpty())     // 检查没有测试用例的情况
            NotExistException.throwException("本题没有可用测试用例");

        if (problem.getType() == ProblemType.SQL.index()) {  // 对于SQL还需保证存在前置建表语句 与 后置删表语句
            boolean existPreHandle = false;
            boolean existPostHandle = false;
            for (TestCase testCase : testCases) {
                existPreHandle = existPreHandle || testCase.getIsPrehandle();
                existPostHandle = existPostHandle || testCase.getIsPosthandle();
            }
            if (!existPreHandle || !existPostHandle)
                NotExistException.throwException("SQL题缺少前置建表语句或后置删表语句");
        }

        testCases.sort((t1, t2) -> {   // 按 前置处理 后置处理 优先级综合排序
            final int WEIGHT = 999;
            int t1Order = t1.getTOrder();
            int t2Order = t2.getTOrder();
            // 根据前置与后置处理调整比较权重
            if (t1.getIsPrehandle())
                t1Order +=  WEIGHT;
            else if (t1.getIsPosthandle())
                t1Order -=  WEIGHT;
            if (t2.getIsPrehandle())
                t2Order +=  WEIGHT;
            else if (t2.getIsPosthandle())
                t2Order -=  WEIGHT;
            return t2Order - t1Order;
        });
        return testCases;
    }


}
