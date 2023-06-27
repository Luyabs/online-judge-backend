package com.example.onlinejudge;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.CaseLoader;
import com.example.onlinejudge.judgebox.core.ResultWriter;
import com.example.onlinejudge.judgebox.fascade.JudgeBox;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JudgeBoxTest {
    @Autowired
    private JudgeBox judgeBox;

    @Autowired
    private CaseLoader caseLoader;

    @Autowired
    private ResultWriter resultWriter;

    @Test
    void testJudgeBox() {
        judgeBox.setSaveMode(ResultWriter.SaveMode.CONSOLE);
        Submission submission = new Submission().setProblemId(5L);
        judgeBox.judge(submission);
    }

    @Test
    void testCaseLoader() {
        Submission submission = new Submission().setProblemId(1673371637459791873L);
        List<TestCase> testCases = caseLoader.loadTestCase(submission);
        System.out.println(testCases);
    }

    @Test
    void testResultWriter() {
        resultWriter.setSaveMode(ResultWriter.SaveMode.CONSOLE);
        resultWriter.write(new Submission().setProblemId(123L).setCode("adsadasdsadsa"));
    }
}
