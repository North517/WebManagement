package com.north.tliaswebmanagement.mapper;


import com.north.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
//@Mapper
//public interface EmpMapper {
//
//    /**
//     * 查询总记录数
//     * @return
//     */
////    @Select("select count(*) from emp")
//    public Long count();
//
//    /**
//     * 分页查询,获取列表数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    //@Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);
//
//    /**
//     * 员工信息查询
//     * @return
//     */
//    @Select("select * from emp")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
//
//    /**
//     * 批量删除
//     * @param
//     */
//    void delete(List<Integer> ids);
//
//
//    /**
//     * 新增员工
//     * @param emp
//     */
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
//            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
//    void insert(Emp emp);
//
//    /**
//     * 根据ID查询员工
//     * @param id
//     * @return
//     */
//    @Select("select * from emp where  id = #{id}")
//    Emp getById(Integer id);
//
//    /**
//     * 更新员工
//     * @param emp
//     */
//    void update(Emp emp);
//
//
//    @Select("select * from emp where username = #{username} and password = #{password}")
//    Emp getByUsernameAndPassword(Emp emp);
//
//
//    /**
//     * 根据部门ID删除该门下的员工数据
//     *
//     */
//
//    @Delete("delete from emp where dept_id = #{deptId}")
//    void deleteByDeptId(Integer deptId);
//
//}







//@Mapper
//public interface EmpMapper {
//
//    /**
//     * 查询总记录数
//     * @return
//     */
//    @Select("select count(*) from emp")  // 恢复注解
//    public Long count();
//
//    /**
//     * 分页查询,获取列表数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start},#{pageSize}")  // 恢复注解
//    public List<Emp> page(Integer start, Integer pageSize);
//
//    /**
//     * 员工信息查询
//     * @return
//     */
//    // 删除@Select注解，使用XML映射
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
//
//    /**
//     * 批量删除
//     * @param
//     */
//    void delete(List<Integer> ids);  // XML中有映射，无需注解
//
//    /**
//     * 新增员工
//     * @param emp
//     */
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
//            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
//    void insert(Emp emp);  // XML中无映射，需保留注解
//
//    /**
//     * 根据ID查询员工
//     * @param id
//     * @return
//     */
//    @Select("select * from emp where  id = #{id}")
//    Emp getById(Integer id);  // XML中无映射，需保留注解
//
//    /**
//     * 更新员工
//     * @param emp
//     */
//    void update(Emp emp);  // XML中有映射，无需注解
//
//    @Select("select * from emp where username = #{username} and password = #{password}")
//    Emp getByUsernameAndPassword(Emp emp);  // XML中无映射，需保留注解
//
//    /**
//     * 根据部门ID删除该门下的员工数据
//     *
//     */
//    @Delete("delete from emp where dept_id = #{deptId}")
//    void deleteByDeptId(Integer deptId);  // XML中无映射，需保留注解
//}


///**
// * 员工管理
// */
//@Mapper
//public interface EmpMapper {
//
//    /**
//     * 查询总记录数
//     * @return
//     */
//    //@Select("select count(*) from emp")
//    //public Long count();
//
//    /**
//     * 分页查询,获取列表数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    //@Select("select * from emp limit #{start},#{pageSize}")
//    //public List<Emp> page(Integer start, Integer pageSize);
//
//    /**
//     * 员工信息查询
//     * @return
//     */
//    //@Select("select * from emp")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
//
//    /**
//     * 批量删除
//     * @param ids
//     */
//    void delete(List<Integer> ids);
//
//    /**
//     * 新增员工
//     * @param emp
//     */
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
//            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
//    void insert(Emp emp);
//
//    /**
//     * 根据ID查询员工
//     * @param id
//     * @return
//     */
//    @Select("select * from emp where  id = #{id}")
//    Emp getById(Integer id);
//
//    /**
//     * 更新员工
//     * @param emp
//     */
//    void update(Emp emp);
//
//    /**
//     * 根据用户名和密码查询员工
//     * @param emp
//     * @return
//     */
//    @Select("select * from emp where username = #{username} and password = #{password}")
//    Emp getByUsernameAndPassword(Emp emp);
//
//    /**
//     * 根据部门ID删除该部门下的员工数据
//     * @param deptId
//     */
//    @Delete("delete  from emp where dept_id = #{deptId}")
//    void deleteByDeptId(Integer deptId);
//}


@Mapper
public interface EmpMapper {

    /**
     * 员工信息条件查询（XML实现）
     */
    List<Emp> list(
            @Param("name") String name,  // 必须添加@Param注解，与XML参数匹配
            @Param("gender") Short gender,
            @Param("begin") LocalDate begin,
            @Param("end") LocalDate end
    );

    /**
     * 批量删除（XML实现）
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工（注解实现，如需统一为XML可迁移，此处保留不影响）
     */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID查询员工（注解实现，如需统一为XML可迁移，此处保留不影响）
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工（XML实现）
     */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询（注解实现，如需统一为XML可迁移，此处保留不影响）
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门ID删除员工（注解实现，如需统一为XML可迁移，此处保留不影响）
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}