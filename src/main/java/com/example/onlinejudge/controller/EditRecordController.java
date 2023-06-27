package com.example.onlinejudge.controller;

import com.example.onlinejudge.common.Result;
import com.example.onlinejudge.common.base.BaseController;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.entity.EditRecord;
import com.example.onlinejudge.entity.Problem;
import com.example.onlinejudge.service.EditRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Luyabs & 2020ljj
 * @since 2023-06-13 11:06:32
 */
@RestController
@RequestMapping("/edit_record")
public class EditRecordController extends BaseController<EditRecord> {

}
