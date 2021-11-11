package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * @author sqh
 * @create 2021-06-05
 */
@Transactional(readOnly = true)//开启事务只读（业务层比较查询多，增删改比较少）
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    @Transactional(readOnly = false)//对于增删改单独设置
    boolean save(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Transactional(readOnly = false)//对于增删改单独设置
    boolean update(User user);

    /**
     * 删除用户
     * @param uuid
     * @return
     */
    @Transactional(readOnly = false)//对于增删改单独设置
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
    PageInfo<User> getAll(int page, int size);

    /**
     * 根据用户名和密码登陆
     *
     * 数据层的方法一般不用业务名称作为它的方法名，这里业务层要进行更改
     * @param userName
     * @param password
     * @return
     */
    User login(String userName,String password);
}
