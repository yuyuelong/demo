package com.yyl.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "hello/{name}",method = RequestMethod.GET)
    public String say(@PathVariable(value = "name")String name){
        log.info("say hello to {}",name);
        return name;
    }

}
