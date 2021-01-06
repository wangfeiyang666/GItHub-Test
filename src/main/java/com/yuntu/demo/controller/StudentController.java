package com.yuntu.demo.controller;

import com.yuntu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/student.html")
    public String student() {
        return "stuindex";
    }
}
