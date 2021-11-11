package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.Userdao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sqh
 * @create 2021-06-05
 */
@Service//定义成bean
public class UserServiceImpl implements UserService {
    @Autowired
//    @Qualifier("userdao")//自动装配(注入)
    private Userdao userdao;

    @Override
    public boolean save(User user) {
        return userdao.save(user);
    }

    @Override
    public boolean update(User user) {
        return userdao.update(user);
    }

    @Override
    public boolean delete(Integer uuid) {
        return userdao.delete(uuid);
    }

    @Override
    public User get(Integer uuid) {
        return userdao.get(uuid);
    }

    @Override
    public PageInfo<User> getAll(int page,int size) {
        PageHelper.startPage(page,size);//设定(页数，条数)开始和结束
        List<User> all = userdao.getAll();
        return new PageInfo<User>(all);
    }

    @Override
    public User login(String userName, String password) {
        return userdao.getByUserNameAndPassword(userName,password);
    }
}
