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
@TableName("edit_record")
public class EditRecord {

    /**
     * 修改记录id
     */
    @TableId(value = "edit_record_id", type = IdType.ASSIGN_ID)
    private Long editRecordId;

    /**
     * 修改者id
     */
    private Long userId;

    /**
     * 原始题目id
     */
    private Long originalProblemId;

    /**
     * 是否修改测试用例
     */
    private Boolean isTestCase;

    /**
     * 原始测试用例id
     */
    private Long originalTestCaseId;

    /**
     * 修改行为
     */
    private Integer changeAction;

    /**
     * 修改的临时题目id
     */
    private Long editProblemId;

    /**
     * 修改的临时用例id
     */
    private Long editTestCaseId;

    /**
     * 是否由管理员修改
     */
    private Boolean isAdmin;

    /**
     * 修改状态
     */
    private Integer status;

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
