package com.example.onlinejudge.judgebox.fascade;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.CaseLoader;
import com.example.onlinejudge.judgebox.core.JudgeCore;
import com.example.onlinejudge.judgebox.core.ResultWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 判题机(外观实现类)
 */
@Component
public class JudgeBoxImpl implements JudgeBox {
    @Autowired
    private CaseLoader caseLoader;

    @Autowired
    private JudgeCore judgeCore;

    @Autowired
    private ResultWriter resultWriter;

    @Override
    public Submission judge(Submission submission) {
        List<TestCase> testCases = caseLoader.loadTestCase(submission);
        judgeCore.judge(submission, testCases);
        resultWriter.write(submission);
        return submission;
    }
}
