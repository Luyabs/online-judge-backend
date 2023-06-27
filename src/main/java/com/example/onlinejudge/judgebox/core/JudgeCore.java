package com.example.onlinejudge.judgebox.core;

import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.constant.Language;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.judger.JavaJudge;
import com.example.onlinejudge.judgebox.core.judger.Judge;
import com.example.onlinejudge.judgebox.core.judger.MysqlJudge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 判题核心
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

    public Submission judge(Submission submission, List<TestCase> testCases) {
        Judge languageJudge = judgeFactory(submission);
        return languageJudge.judge(submission, testCases);
    }
}
