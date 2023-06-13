package com.example.onlinejudge.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mybatis Plus
 * 元数据对象处理器: 处理公共字段
 */
@Component
public class AutoFillMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("insertTime", LocalDateTime.now());
//        if (UserInfo.get() != null)
//            metaObject.setValue("insertUser", UserInfo.get());
        updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", LocalDateTime.now());
//        if (UserInfo.get() != null)
//            metaObject.setValue("updateUser", UserInfo.get());
    }
}
