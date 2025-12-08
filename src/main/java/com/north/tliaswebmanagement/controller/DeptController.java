package com.north.tliaswebmanagement.controller;


import com.north.tliaswebmanagement.pojo.Dept;
import com.north.tliaswebmanagement.pojo.Result;
import com.north.tliaswebmanagement.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //注入实现类接口
    @Autowired
    private DeptService deptService;

    /*
     * 前端发送请求，到controller.Result方法中
     * */

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    //指定请求方式为GWT
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        /*
        接收前端,调用servise查询数据
        拿到service返回的数据，提交给前端
         */
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }


    /*
    删除部门
     */
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门：{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /*
    新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
    修改部门
     */
//    @PutMapping
//    public Result update(@RequestBody Dept dept) {
//        deptService.update(dept);
//        return Result.success();
//    }

//
//    @PutMapping
//    public Result update(@RequestBody Dept dept) {
//        log.info("更新员工信息{}",dept);
//        deptService.update(dept);
//        return Result.success();
//    }


    // 根据部门id查询部门信息
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查找部门:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    // 修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}