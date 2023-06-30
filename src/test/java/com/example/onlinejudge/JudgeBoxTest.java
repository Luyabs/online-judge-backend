package com.example.onlinejudge;

import com.example.onlinejudge.constant.Language;
import com.example.onlinejudge.constant.ProblemType;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.CaseLoader;
import com.example.onlinejudge.judgebox.core.ResultWriter;
import com.example.onlinejudge.judgebox.core.judger.MysqlJudge;
import com.example.onlinejudge.judgebox.fascade.JudgeBox;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class JudgeBoxTest {
    @Autowired
    private JudgeBox judgeBox;

    @Autowired
    private CaseLoader caseLoader;

    @Autowired
    private MysqlJudge mysqlJudge;

    @Autowired
    private ResultWriter resultWriter;

    @Test
    void testResultWriter() {
        resultWriter.setSaveMode(ResultWriter.SaveMode.CONSOLE);
        resultWriter.write(new Submission().setProblemId(123L).setCode("adsadasdsadsa"));
    }

    @Test
    void testMysqlJudgeDql() {
        Submission submission = new Submission().setLanguage(Language.MYSQL.index()).setCode("select * from test");
        List<TestCase> testCases = caseLoader.loadTestCase(new Problem().setProblemId(4L).setType(ProblemType.SQL.index()));
        mysqlJudge.judge(submission, testCases, new Problem());
        System.out.println(submission);
    }

    @Test
    void testMysqlJudgeDml() {
        Submission submission = new Submission().setLanguage(Language.MYSQL.index()).setCode("update test set name = '丁真' where id <=3");
        List<TestCase> testCases = caseLoader.loadTestCase(new Problem().setProblemId(5L).setType(ProblemType.SQL.index()));
        mysqlJudge.judge(submission, testCases, new Problem());
        System.out.println(submission);
    }


    @Test
    void testJudgeBox() {
//        judgeBox.setSaveMode(ResultWriter.SaveMode.CONSOLE);
//        judgeBox.setSaveMode(ResultWriter.SaveMode.FILE);
        judgeBox.setSaveMode(ResultWriter.SaveMode.DATABASE);
        Submission submission = new Submission()
                .setProblemId(5L)
                .setIsDebug(true)
                .setLanguage(Language.MYSQL.index())
                .setCode("update test set name = '丁真' where id <=3");
        judgeBox.judge(submission);
    }
}
