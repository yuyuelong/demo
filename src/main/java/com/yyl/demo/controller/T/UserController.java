package com.yyl.demo.controller.T;

import com.yyl.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Value("${weight:65}")
    private Double weight;


    @Autowired
    private User user;

    @GetMapping(value = "say")
    public User say(){
        System.out.println("体重:"+weight+"公斤");
        return user;
    }
}
