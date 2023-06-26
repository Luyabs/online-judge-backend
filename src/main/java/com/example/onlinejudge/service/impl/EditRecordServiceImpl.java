package com.example.onlinejudge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinejudge.common.exception.exception.NotExistException;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.dto.EditRecordDto;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.mapper.EditRecordMapper;
import com.example.onlinejudge.service.EditRecordService;
import com.example.onlinejudge.common.base.BaseServiceImpl;
import com.example.onlinejudge.vo.AuditQueryConditionVo;
import org.apache.commons.lang3.ObjectUtils;
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
    public IPage<EditRecordDto> getPageDto(int currentPage, int pageSize, AuditQueryConditionVo condition) {
        QueryWrapper<EditRecordDto> wrapper = new QueryWrapper<EditRecordDto>()
                .like(ObjectUtils.isNotEmpty(condition.getTitle()), "p.title", condition.getStatus())
//                .like(ObjectUtils.isNotEmpty(condition.getTag()), "e.status", condition.getStatus())
                .eq(ObjectUtils.isNotEmpty(condition.getChangeAction()), "e.change_action", condition.getChangeAction())
                .eq(ObjectUtils.isNotEmpty(condition.getStatus()), "e.status", condition.getStatus())
                .orderByDesc("e.update_time");
        return editRecordMapper.selectPageDto(new Page<>(currentPage, pageSize), wrapper);
    }

    @Override
    public EditRecordDto getByIdDtoNotNull(long editRecordId) {
        EditRecordDto editRecordDto = editRecordMapper.selectByIdDto(editRecordId);
        NotExistException.throwIf(editRecordDto == null, editRecordId, "修改记录");
        return editRecordDto;
    }
}
