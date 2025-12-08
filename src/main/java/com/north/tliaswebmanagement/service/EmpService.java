package com.north.tliaswebmanagement.service;

import com.north.tliaswebmanagement.pojo.Emp;
import com.north.tliaswebmanagement.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 删除员工
     */

    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);


    /**
     * 员工登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);

}
