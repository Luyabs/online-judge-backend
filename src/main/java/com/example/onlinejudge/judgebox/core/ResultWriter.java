package com.example.onlinejudge.judgebox.core;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.mapper.SubmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultWriter {
    @Autowired
    private SubmissionMapper submissionMapper;

    public void write(Submission submission) {
        // TODO
    }
}
