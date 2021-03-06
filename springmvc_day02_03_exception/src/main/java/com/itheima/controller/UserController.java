package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/save")
    @ResponseBody//转成json数据，返回到ajax.jsp
    public List<User> save(@RequestBody User user) {//接收user数据
        System.out.println("user controller save is running ...");

        //模拟业务层发起调用产生了异常
//        int i = 1/0;////遇到第一个异常，这个程序就停止了
//        String str = null;
//        str.length();

        //对用户的非法操作进行判定，并包装成异常对象进行处理，便于统一管理
        if(user.getName().trim().length() < 8){
            throw new BusinessException("对不起，用户名长度不满足要求，请重新输入！");
            /*
            public BusinessException(String message) {
            这里其实是在new一个新的异常
             */
        }
        if(user.getAge() < 0){
            throw new BusinessException("对不起，年龄必须是0到100之间的数字！");
        }
        if(user.getAge() > 100){
            throw  new SystemException("服务器连接失败，请尽快检查处理！");
        }


        User u1 = new User();
        u1.setName("Tom");
        u1.setAge(3);
        User u2 = new User();
        u2.setName("Jerry");
        u2.setAge(5);
        ArrayList<User> al = new ArrayList<User>();
        al.add(u1);
        al.add(u2);

        return al;
    }
}
