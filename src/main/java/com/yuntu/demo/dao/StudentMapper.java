package com.yuntu.demo.dao;

import com.yuntu.demo.pojo.PageUtil;
import com.yuntu.demo.pojo.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    @Select("SELECT t.* FROM student t LIMIT ${(pageindex-1)*pagesize},#{pagesize}")
    List<Student> SelStudentLists(PageUtil pageUtil);

    //查询总数
    @Select("select count(1) from student")
    int Conts();
}
