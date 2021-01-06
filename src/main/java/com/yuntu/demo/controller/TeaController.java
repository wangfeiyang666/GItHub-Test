package com.yuntu.demo.controller;

import com.yuntu.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tea")
public class TeaController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/TeaIndex.html")
    public String hello(){
        return "TeaIndex";
    }
}
