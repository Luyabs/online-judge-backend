package com.example.onlinejudge.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private LocalDateTime updateTime;

    /**
     * 题目新增时间
     */
    private LocalDateTime insertTime;
}
