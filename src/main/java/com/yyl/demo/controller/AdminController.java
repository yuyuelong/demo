package com.yyl.demo.controller;

import com.yyl.demo.Util.FileUtil;
import com.yyl.demo.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController extends BaseController<Integer,Admin>{
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private FileUtil fileUtil;

    public void validParam(BindingResult bindingResult){}

    @GetMapping("toLogin")
    public String toLoin(ModelMap model){
        model.addAttribute("name","james");
        return "login";
    }

    @GetMapping(value = "upload")
    @ResponseBody
    public String upload(){
       return fileUtil.uploadFile() ? "success" : "fail";
    }


    @PostMapping("login")
    @ResponseBody
    public String login(@Valid @RequestBody Admin admin, BindingResult bindingResult) throws Exception{
        fileUtil.uploadFile();
        Map<String,Object> map = new HashMap<String,Object>();
        String code = "200";//默认成功
        String message = "";
        if(bindingResult.hasErrors()){//校验失败
            code = "201";
            message = bindingResult.getFieldError().getDefaultMessage();
            log.info("Field Errorssss {}",bindingResult.getFieldError().getField());
            throw new RuntimeException("dsdfsdf");
        }else{

        }
        map.put("code",code);
        map.put("message",message);
        return map.toString();
    }


}
