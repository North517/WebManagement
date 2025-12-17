package com.north.tliaswebmanagement.mapper;


import com.north.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 以下注解部分是这样的：
 * list/delete/update方法，只有 XML 的 SQL；
 * insert/getById等方法，只有注解的 SQL；
 *
 * 已废弃，下面已全部使用 XML 的 SQL
 */
//@Mapper
//public interface EmpMapper {
//
//    /**
//     * 员工信息条件查询（XML实现）
//     */
//    List<Emp> list(
//            @Param("name") String name,  // 必须添加@Param注解，与XML参数匹配
//            @Param("gender") Short gender,
//            @Param("begin") LocalDate begin,
//            @Param("end") LocalDate end
//    );
//
//    /**
//     * 批量删除（XML实现）
//     */
//    void delete(List<Integer> ids);
//
//    /**
//     * 新增员工（注解实现，如需统一为XML可迁移，此处保留不影响）
//     */
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
//            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
//    void insert(Emp emp);
//
//    /**
//     * 根据ID查询员工（注解实现，如需统一为XML可迁移，此处保留不影响）
//     */
//    @Select("select * from emp where id = #{id}")
//    Emp getById(Integer id);
//
//    /**
//     * 更新员工（XML实现）
//     */
//    void update(Emp emp);
//
//    /**
//     * 根据用户名和密码查询（注解实现，如需统一为XML可迁移，此处保留不影响）
//     */
//    @Select("select * from emp where username = #{username} and password = #{password}")
//    Emp getByUsernameAndPassword(Emp emp);
//
//    /**
//     * 根据部门ID删除员工（注解实现，如需统一为XML可迁移，此处保留不影响）
//     */
//    @Delete("delete from emp where dept_id = #{deptId}")
//    void deleteByDeptId(Integer deptId);
//}


@Mapper
public interface EmpMapper {

    /**
     * 员工信息条件查询（XML实现）
     */
    List<Emp> list(
            @Param("name") String name,
            @Param("gender") Short gender,
            @Param("begin") LocalDate begin,
            @Param("end") LocalDate end
    );

    /**
     * 批量删除员工（XML实现）
     * 建议添加@Param("ids")注解，避免XML中collection取值歧义（可选优化）
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工（XML实现：原注解已迁移）
     */
    void insert(Emp emp);

    /**
     * 根据ID查询员工（XML实现：原注解已迁移）
     */
    Emp getById(Integer id);

    /**
     * 更新员工（XML实现）
     */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询员工（XML实现：原注解已迁移）
     */
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门ID删除员工（XML实现：原注解已迁移）
     */
    void deleteByDeptId(Integer deptId);
}