package com.yuntu.demo.service.impl;

import com.yuntu.demo.dao.TeacherMapper;
import com.yuntu.demo.pojo.Teacher;
import com.yuntu.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }
}
