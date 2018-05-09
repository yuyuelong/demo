package com.yyl.demo.controller;

import com.yyl.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Say
 */
@Controller
@RequestMapping("say")
public class SayController {

    @GetMapping("say")
    public String say(ModelMap model, HttpServletRequest request){

        HttpSession session = request.getSession();

        session.setAttribute("name","kobeAndJames");

        List<User> userList = new ArrayList<User>();


        User user = new User();
        user.setAge(19);
        user.setUsername("james");

        User user2 = new User();
        user2.setAge(20);
        user2.setUsername("jack");

        User user3 = new User();
        user3.setAge(21);
        user3.setUsername("kobe");

        User user4 = new User();
        user4.setAge(22);
        user4.setUsername("xiaoyu");

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        model.addAttribute("v",1);
        model.addAttribute("baidu","百度");
        model.addAttribute("imooc","爱慕客");


        model.addAttribute("userDate",System.currentTimeMillis());


        model.addAttribute("say","hello spring boot");
        model.addAttribute("user",user);
        model.addAttribute("userList",userList);

     //   model.addAttribute("email","http://www.baidu.com");
        return "demo";
    }
}
