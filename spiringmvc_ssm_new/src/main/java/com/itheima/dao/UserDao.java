package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author sqh
 * @create 2021-11-23
 */
public interface UserDao {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 删除用户
     *
     * @param uuid
     * @return
     */
    public boolean delete(Integer uuid);

    /**
     * 查询单个用户信息
     *
     * @param uuid
     * @return
     */
    public User get(Integer uuid);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    public List<User> getAll();//因为使用分页插件，不需要参数int page和int size。

    /**
     * 根据用户名密码查询用户信息
     * 登录的功能（其实就是查询用户名和密码）（数据层的方法一般只是体现和数据打交道的方式，这里不用login）
     *
     * @param userName
     * @param password
     * @return
     */
    public User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
