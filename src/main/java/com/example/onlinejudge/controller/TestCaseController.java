package com.example.onlinejudge.controller;

import com.example.onlinejudge.common.exception.handler.base.BaseController;
import com.example.onlinejudge.entity.TestCase;
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
@RequestMapping("/testCase")
public class TestCaseController extends BaseController<TestCase> {

}
