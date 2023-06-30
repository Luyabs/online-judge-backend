package com.example.onlinejudge.judgebox.core;

import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.Language;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.judger.JavaJudge;
import com.example.onlinejudge.judgebox.core.judger.Judge;
import com.example.onlinejudge.judgebox.core.judger.MysqlJudge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 判题核心 <br/>
 * 负责根据题目采用语言调度不同语言的判题器 <br/>
 * 负责使用判题器与测试用例对用户的提交进行判题 <br/>
 * 如果判题过程中产生了问题或结果，(如Wrong Answer, 沙箱抛掷异常等)那么会记录在submission中 <br/>
 * 判题核心同样不会进行数据库存储 <br/>
 */
@Component
public class JudgeCore {
    @Autowired
    private MysqlJudge mysqlJudge;

    @Autowired
    private JavaJudge javaJudge;

    private Judge judgeFactory(Submission submission) {
        Language language = Language.get(submission.getLanguage());
        return switch (language) {
            case MYSQL -> mysqlJudge;
            case JAVA -> javaJudge;
            default -> throw new ServiceException("该语言暂不支持");
        };
    }

    public Submission judge(Submission submission, List<TestCase> testCases, Problem problem) {
        Judge languageJudge = judgeFactory(submission);
        return languageJudge.judge(submission, testCases, problem);
    }
}
