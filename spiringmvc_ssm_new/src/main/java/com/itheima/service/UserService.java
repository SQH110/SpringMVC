package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sqh
 * @create 2021-11-23
 */
@Transactional(readOnly = true)//开为只读，因为业务层查询多，增删少（特殊的单独加）
public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(User user);

    /**
     * 删除用户
     *
     * @param uuid
     * @return
     */
    @Transactional(readOnly = false)
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
    public PageInfo<User> getAll(int page , int size);

    /**
     * 根据用户名密码登录
     * 登录的功能（其实就是查询用户名和密码）（数据层的方法一般只是体现和数据打交道的方式，这里不用login）
     * 业务层方法名按照业务的需要取名
     *
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password);
}
