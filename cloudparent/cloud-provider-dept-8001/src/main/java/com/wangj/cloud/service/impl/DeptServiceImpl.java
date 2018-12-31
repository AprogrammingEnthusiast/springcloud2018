package com.wangj.cloud.service.impl;

import com.wangj.cloud.mapper.DeptMapper;
import com.wangj.cloud.service.DeptService;
import com.wangj.cloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.fingById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
