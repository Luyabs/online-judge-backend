package com.example.onlinejudge.judgebox.fascade;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.judgebox.core.ResultWriter;

/**
 * 判题沙箱 (外观接口)
 */
public interface JudgeBox {
    Submission judge(Submission submission);

    /**
     * 设置保存方式
     * @param saveMode DATABASE / CONSOLE / FILE
     */
    void setSaveMode(ResultWriter.SaveMode saveMode);
}
