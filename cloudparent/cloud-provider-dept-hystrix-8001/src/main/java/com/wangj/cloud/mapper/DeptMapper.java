package com.wangj.cloud.mapper;

import com.wangj.cloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    public boolean addDept(Dept dept);

    public Dept fingById(Long id);

    public List<Dept> findAll();

}
