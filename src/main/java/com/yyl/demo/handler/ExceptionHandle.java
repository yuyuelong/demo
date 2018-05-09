package com.yyl.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理</br>
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e){
        String code = "500";
        String message = "服务器异常";
        if(e instanceof RuntimeException){
            code = "300";
            message = e.getMessage();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",code);
        map.put("message",message);
        return map.toString();
    }
}
