package com.example.onlinejudge.judgebox.fascade;

import com.example.onlinejudge.entity.Submission;

/**
 * 判题机 (外观接口)
 */
public interface JudgeBox {
    Submission judge(Submission submission);
}
