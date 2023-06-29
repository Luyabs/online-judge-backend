package com.example.onlinejudge.entity.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *  记录通过的题目数量(根据题目难度分属性）POJO类
 */
@Data
@Accessors(chain = true)
public class ProNumByDifficulty {

    /**
     * 通过的简单的题目数量
     */
    private Integer easyProNum;

    /**
     * 通过的中等的题目数量
     */
    private Integer mediumProNum;

    /**
     * 通过的困难的题目数量
     */
    private Integer hardProNum;

}
