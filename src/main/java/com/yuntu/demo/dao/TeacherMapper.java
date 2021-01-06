package com.yuntu.demo.dao;

import com.yuntu.demo.pojo.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherMapper {
    //查询全部
    @Select("SELECT tea.* FROM tb_teacher tea")
    List<Teacher> getAll();
}
