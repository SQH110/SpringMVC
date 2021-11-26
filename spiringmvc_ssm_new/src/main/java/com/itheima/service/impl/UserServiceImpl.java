package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author sqh
 * @create 2021-11-23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //提高set方法
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public boolean save(User user) {
        return userDao.save(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean delete(Integer uuid) {
        return userDao.delete(uuid);
    }

    public User get(Integer uuid) {
        return userDao.get(uuid);
    }

    public PageInfo<User> getAll(int page , int size) {
        //使用分页插件
        PageHelper.startPage(page,size);
        List<User> all = userDao.getAll();
        return new PageInfo<User>(all);
    }

    public User login(String userName, String password) {
        return userDao.getByUserNameAndPassword(userName,password);
    }
}
