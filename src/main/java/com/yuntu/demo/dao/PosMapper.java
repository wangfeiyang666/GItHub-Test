package com.yuntu.demo.dao;

import com.yuntu.demo.pojo.Position;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PosMapper {
    @Select("select * from tb_position")
    List<Position> getAll();
}
