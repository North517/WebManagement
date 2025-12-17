package com.north.tliaswebmanagement.exception;
/*
* 全局异常处理器
*
* */

import com.north.tliaswebmanagement.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex (Exception ex){
        ex.printStackTrace();
        return Result.error("对不起，请联系工作人员    微信：North-517");
    }

}
