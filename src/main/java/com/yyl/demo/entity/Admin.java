package com.yyl.demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

/**
 * 管理员</br>
 */
@Data
@Component
public class Admin {
    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "用户密码不能为空")
    @Length(min = 6,message = "用户密码长度不能小于6位数")
    private String pwd;
}
