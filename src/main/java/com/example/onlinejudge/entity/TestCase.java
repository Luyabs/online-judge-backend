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
@TableName("test_case")
public class TestCase {

    /**
     * 测试用例id
     */
    @TableId(value = "test_case_id", type = IdType.ASSIGN_ID)
    private Long testCaseId;

    /**
     * 题目id
     */
    private Long problemId;

    /**
     * 测试输入
     */
    private String input;

    /**
     * 预期输出结果
     */
    private String output;

    /**
     * 测试描述
     */
    private String description;

    /**
     * 是否为预处理语句
     */
    private Boolean isPrehandle;

    /**
     * 是否为后置处理语句
     */
    private Boolean isPosthandle;

    /**
     * 测试用例顺序
     */
    private Integer order;

    /**
     * 是否通过审核
     */
    private Boolean isVerified;

    /**
     * 审核附加信息
     */
    private String verifyMessage;

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
