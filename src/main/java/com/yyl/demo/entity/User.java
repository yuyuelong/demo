package com.yyl.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 用户</br>
 */
@Data
@ConfigurationProperties(prefix = "user")
@Component
public class User {

    private Integer id;

    private String username;

    private Integer age;

    private Double height;
}
