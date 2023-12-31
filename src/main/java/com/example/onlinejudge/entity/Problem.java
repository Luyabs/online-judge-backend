package com.example.onlinejudge.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
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
@Data
@Accessors(chain = true)
@TableName("problem")
public class Problem implements Serializable {

    /**
     * 题目id
     */
    @TableId(value = "problem_id", type = IdType.ASSIGN_ID)
    private Long problemId;

    /**
     * 作者id
     */
    private Long userId;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题目类型
     */
    private Integer type;

    /**
     * 总尝试次数
     */
    private Integer attemptNum;

    /**
     * 总通过次数
     */
    private Integer successNum;

    /**
     * 难度
     */
    private Integer difficulty;

    /**
     * 运行时间限制
     */
    private Double runtimeLimit; //不大于128ms

    /**
     * 运行内存限制
     */
    private Double memoryLimit; //不大于128m

    /**
     * 状态
     */
    private Integer status;     //0:未审核 1:审核通过 2: 审核中 3:审核不通过 4:历史

    /**
     * 题目信息更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 题目新增时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @JsonSerialize(using = LocalDateTimeSerializer.class) // Jackson序列化
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class) // Jackson反序列化
//    @TableField(fill = FieldFill.INSERT)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime insertTime;
}
