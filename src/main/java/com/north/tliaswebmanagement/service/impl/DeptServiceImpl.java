package com.north.tliaswebmanagement.service.impl;


import com.north.tliaswebmanagement.mapper.DeptMapper;
import com.north.tliaswebmanagement.mapper.EmpMapper;
import com.north.tliaswebmanagement.pojo.Dept;
import com.north.tliaswebmanagement.pojo.Emp;
import com.north.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    //查询部门
    @Override
    public List<Dept> list() {

        /*
        调用mapper接口中的方法，操作数据库
        接收到mapper中的List数据库返回值
        再返回将其返回到controller中
         */
        return deptMapper.list();
    }



    //删除部门
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
        empMapper.deleteByDeptId(id);//根据部门id删除部门员工数据
    }


    //新增部门
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);

    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }


    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


    }

