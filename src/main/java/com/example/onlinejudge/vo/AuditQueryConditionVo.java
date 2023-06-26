package com.example.onlinejudge.vo;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AuditQueryConditionVo {
    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private List<String> tag;

    /**
     * 修改状态
     */
    private Integer status;

    /**
     * 修改行为
     */
    private Integer changeAction;
}
