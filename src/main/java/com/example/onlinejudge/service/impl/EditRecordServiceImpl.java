package com.example.onlinejudge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.service.EditRecordService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@Service
public class EditRecordServiceImpl extends BaseServiceImpl<EditRecordMapper, EditRecord> implements EditRecordService {
    @Autowired
    private EditRecordMapper editRecordMapper;

    @Override
    public IPage<EditRecord> getPage(int currentPage, int pageSize, EditStatus status) {
        QueryWrapper<EditRecord> wrapper = new QueryWrapper<EditRecord>()
                .eq("status", status.index())
                .orderByDesc("update_time");
        return editRecordMapper.selectPage(new Page<>(currentPage, pageSize), wrapper);
    }
}
