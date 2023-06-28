package com.example.onlinejudge.judgebox.core;

import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.mapper.SubmissionMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 判题结果输出器 <br/>
 * 可以设置不同的策略来以不同方式持久化的保存submission <br/>
 * 提供以下三种保存submission的方式: <br/>
 * DATABASE: 作为记录保存到数据库中Submission表中 <br/>
 * FILE: 作为文件保存到项目目录下 <br/>
 * CONSOLE: 只在控制台中输出,不保存 <br/>
 */
@Component
@Data
@Slf4j
public class ResultWriter {
    public enum SaveMode {DATABASE, CONSOLE, FILE}

    @Autowired
    private SubmissionMapper submissionMapper;

    private SaveMode saveMode = SaveMode.DATABASE;

    public void write(Submission submission) {
        switch (this.saveMode) {
            case CONSOLE -> log.warn(submission.toString() + " [不会以任何形式保存本数据]");
            case DATABASE -> submissionMapper.insert(submission);
            case FILE -> {
                File outfile = new File("submission-" + submission.getInsertTime());
                try (PrintWriter out = new PrintWriter(outfile, StandardCharsets.UTF_8)) {
                    out.println(submission);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
