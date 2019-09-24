package com.qfedu.exception;

import com.qfedu.common.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@ControllerAdvice // 必须使用该注解
//@ResponseBody
@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    public JsonResult exception(Exception ex){

        return new JsonResult(1, ex.getMessage());
    }
}
