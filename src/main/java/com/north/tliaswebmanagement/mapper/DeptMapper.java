package com.north.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.north.tliaswebmanagement.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;


/**
 * 以下注解部分是这样的：只有注解的 SQL；
 *
 * 已废弃，下面已全部使用 XML 的 SQL
 */
//@Mapper
//public interface DeptMapper {
//
//    //查询全部部门数据
//
//
//    /*向数据库中发送指令语句*/
//    @Select("select * from dept")
//    /*查询结果返回封装在list中，返回给servisce中*/
//    List<Dept> list();
//
//    //根据id删除部门
//    @Delete("delete from dept where id = #{id}")
//    void deleteById(Integer id);
//    //新增部门
//    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
//    void insert(Dept dept);
//
//
//    // 根据部门id查询部门信息
//    @Select("select * from dept where id = #{id}")
//    Dept getById(Integer id);
//
//    // 根据部门id更新部门信息
//    @Update("update dept set name = #{name}, create_time = #{createTime}, update_time = #{updateTime} where id = #{id}")
//    void update(Dept dept);
//
//
//
//}

@Mapper
public interface DeptMapper {

    // 查询全部部门数据（XML实现）
    List<Dept> list();

    // 根据id删除部门（XML实现）
    void deleteById(Integer id);

    // 新增部门（XML实现）
    void insert(Dept dept);

    // 根据部门id查询部门信息（XML实现）
    Dept getById(Integer id);

    // 根据部门id更新部门信息（XML实现）
    void update(Dept dept);

}