package com.example.onlinejudge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.onlinejudge.constant.EditStatus;
import com.example.onlinejudge.dto.EditRecordDto;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.common.base.BaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
public interface EditRecordService extends BaseService<EditRecord> {

    IPage<EditRecordDto> getPageDto(int currentPage, int pageSize, EditStatus status);

    EditRecordDto getByIdDtoNotNull(long editRecordId);
}
