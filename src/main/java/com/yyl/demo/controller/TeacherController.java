package com.yyl.demo.controller;

import com.yyl.demo.entity.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class TeacherController extends BaseController<Integer,Teacher> {
}
