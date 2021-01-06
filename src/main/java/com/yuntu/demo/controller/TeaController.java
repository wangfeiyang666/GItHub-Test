package com.yuntu.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuntu.demo.pojo.Teacher;
import com.yuntu.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tea")
public class TeaController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/TeaIndex.html")
    public String hello(){
        return "TeaIndex";
    }

    @RequestMapping("/getPage")
    @ResponseBody
    public PageInfo<Teacher> getPage(String pageNum){
        //需要优化 会使用分页工具，会使用json格式传送数据
        if (pageNum==null || "".equals(pageNum)){
            pageNum="1";
        }
        int index=Integer.parseInt(pageNum);
        PageHelper.startPage(index, 2);
        List<Teacher> list=teacherService.getAll();
        PageInfo<Teacher> pageInfo=new PageInfo<Teacher>(list);
        return pageInfo;
    }
}
