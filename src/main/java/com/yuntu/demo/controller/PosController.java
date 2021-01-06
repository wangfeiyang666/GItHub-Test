package com.yuntu.demo.controller;

import com.yuntu.demo.pojo.PageUtil;
import com.yuntu.demo.pojo.Position;
import com.yuntu.demo.pojo.Student;
import com.yuntu.demo.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pos")
public class PosController {
    @Autowired
    PosService posService;

    @RequestMapping("a")
    public String index() {
        return "index";
    }

    @RequestMapping("/page")
    @ResponseBody
    public List<Position> page(String pageindex) {
        List<Position> pageUtil = posService.getAll();
        return pageUtil;
    }
}
