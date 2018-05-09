package com.yyl.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;


/**
 * JSON对象
 */
@Data
@Component
public class JSONResult {
    private String code;

    private String msg;

    private Object data;
}
