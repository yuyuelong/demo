package com.yyl.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Component
public class Teacher {
    private Integer id;

    @NotEmpty(message = "教师名称不能为空")
    private String name;

    @Min(value = 19,message = "教师名称不能小于19")
    private String age;
}
