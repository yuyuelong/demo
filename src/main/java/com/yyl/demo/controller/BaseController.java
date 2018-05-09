package com.yyl.demo.controller;

import com.yyl.demo.entity.JSONResult;
import com.yyl.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class BaseController<K,T> {

    @Autowired
    private JSONResult jsonResult;

    @PostMapping(value = "save")
    public String save(@Valid @RequestBody T entity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "success";
    }

    @GetMapping("detail")
    @ResponseBody
    public JSONResult detail(K key){
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUsername("james");
        user.setAge(19);
        User user2 = new User();
        user2.setUsername("james");
        user2.setAge(19);
        User user3 = new User();
        user3.setUsername("james");
        user3.setAge(19);
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        jsonResult.setCode("200");
        jsonResult.setData(userList);
        return jsonResult;
    }
}
