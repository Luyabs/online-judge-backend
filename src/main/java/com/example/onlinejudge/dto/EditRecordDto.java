package com.example.onlinejudge.dto;

import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.Problem;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class EditRecordDto extends EditRecord {
    /**
     * 题目标题
     */
    private String title;
}
