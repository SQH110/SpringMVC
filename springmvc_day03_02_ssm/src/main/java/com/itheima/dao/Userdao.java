package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口：MyBatis通过接口代理的方式自动生成实现类对象
 * 数据层：对数据库操作（增删改查）
 * 增删改返回int（影响行数）
 * 查返回一个对象或者对象数组（orm对象关系映射）
 *
 * 数据层的方法一般不用业务名称作为它的方法名
 * @author sqh
 * @create 2021-06-05
 */
public interface Userdao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 删除用户
     * @param uuid
     * @return
     */
    boolean delete(Integer uuid);

    /**
     * 查询单个用户信息
     * @param uuid
     * @return 单个用户
     */
    User get(Integer uuid);

    /**
     * 查询全部用户信息
     *
     * 在业务层利用分页插件，也就不用形参了
     * @return 用户数组
     */
    List<User> getAll();

    /**
     * 根据用户名和密码查询用户信息
     *
     * 这个注释@Param(：传到xml文件中
     *
     * @param userName
     * @param password
     * @return
     */
    User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
