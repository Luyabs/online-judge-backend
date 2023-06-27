package com.example.onlinejudge.entity;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("tag")
public class Tag {

    /**
     * 标签id
     */
    @TableId(value = "tag_id", type = IdType.ASSIGN_ID)
    private Long tagId;

    /**
     * 标签类型
     */
    private String type;

    /**
     * 标签名
     */
    private String name;

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
