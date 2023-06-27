package com.example.onlinejudge.judgebox.fascade;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import com.example.onlinejudge.judgebox.core.CaseLoader;
import com.example.onlinejudge.judgebox.core.JudgeCore;
import com.example.onlinejudge.judgebox.core.ResultWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.onlinejudge.judgebox.core.ResultWriter.SaveMode.DATABASE;

/**
 * 判题沙箱(外观实现类)
 */
@Component
public class JudgeBoxImpl implements JudgeBox {
    @Autowired
    private CaseLoader caseLoader;

    @Autowired
    private JudgeCore judgeCore;

    @Autowired
    private ResultWriter resultWriter;

    /**
     * 判题
     */
    @Override
    @Transactional
    public Submission judge(Submission submission) {
        List<TestCase> testCases = caseLoader.loadTestCase(submission);
        judgeCore.judge(submission, testCases);
        resultWriter.write(submission);
        return submission;
    }

    /**
     * 设置保存方式
     * @param saveMode DATABASE / CONSOLE / FILE
     */
    @Override
    public void setSaveMode(ResultWriter.SaveMode saveMode) {
        resultWriter.setSaveMode(saveMode);
    }
}
