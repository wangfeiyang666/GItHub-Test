package com.yuntu.demo.service.impl;

import com.yuntu.demo.dao.StudentMapper;
import com.yuntu.demo.pojo.PageUtil;
import com.yuntu.demo.pojo.Student;
import com.yuntu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void SelStudentLists(PageUtil pageUtil) {
        int count = studentMapper.Conts();
        if (count > 0) {
            pageUtil.setCounts(count);
            if (pageUtil.getPageindex() > pageUtil.getPagecount()) {
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(studentMapper.SelStudentLists(pageUtil));
        } else {
            pageUtil.setLists(new ArrayList<Student>());
        }
    }
}
