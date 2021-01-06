package com.yuntu.demo.controller;

import com.yuntu.demo.pojo.PageUtil;
import com.yuntu.demo.pojo.Position;
import com.yuntu.demo.pojo.Student;
import com.yuntu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/st")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/st.html")
    public String student() {
        return "stuindex";
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageUtil<Student> page(String pageIndex, Model model) {
        if (pageIndex == null || "".equals(pageIndex)) {
            pageIndex = "1";
        }
        if (Integer.parseInt(pageIndex) < 1) {
            pageIndex = "1";
        }
        PageUtil<Student> pageUtil = new PageUtil<Student>();
        pageUtil.setPageindex(Integer.parseInt(pageIndex));
        pageUtil.setPagesize(3);
        studentService.SelStudentLists(pageUtil);
        model.addAttribute(pageUtil);
        return pageUtil;
    }
}
