package com.example.onlinejudge.common.exception.handler;

import com.example.onlinejudge.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 校验全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class ValidExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result paramExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult exceptions = ex.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                String errorMessage = fieldError.getField() + " " + fieldError.getDefaultMessage();
                log.error("[MethodArgumentNotValidException] " + errorMessage);
                return Result.error().message(errorMessage);
            }
        }
        // 直接报异常
        log.error("[MethodArgumentNotValidException] " + ex.getMessage());
        return Result.error().message(ex.getMessage());
    }
}
