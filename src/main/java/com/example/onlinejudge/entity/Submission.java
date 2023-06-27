package com.example.onlinejudge.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("submission")
public class Submission {

    /**
     * 提交记录id
     */
    @TableId(value = "submission_id", type = IdType.ASSIGN_ID)
    private Long submissionId;

    /**
     * 提交用户id
     */
    private Long userId;

    /**
     * 题目id
     */
    private Long problemId;

    /**
     * 选择语言
     */
    private Integer language;

    /**
     * 提交代码
     */
    private String code;

    /**
     * 是否是调试
     */
    private Boolean isDebug;

    /**
     * 是否运行成功
     */
    private Integer isSuccess;

    /**
     * 错误类型
     */
    private String errorType;

    /**
     * 通过的测试用例数
     */
    private Integer passTestCaseNum;

    /**
     * 代码执行时间
     */
    private Object runtime;

    /**
     * 代码消耗内存
     */
    private Object memory;

    /**
     * 题目信息更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 题目新增时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime insertTime;
}
