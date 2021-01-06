package com.yuntu.demo.service.impl;

import com.yuntu.demo.dao.PosMapper;
import com.yuntu.demo.pojo.Position;
import com.yuntu.demo.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("posService")
public class PosServiceimpl implements PosService {
    @Autowired
    PosMapper posMapper;

    public void setPosMapper(PosMapper posMapper) {
        this.posMapper = posMapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Position> getAll() {
        return posMapper.getAll();
    }
}
