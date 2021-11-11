package com.itheima.service.impl;

import com.itheima.exception.SystemException;

import java.sql.SQLException;

/**
 * 模拟一个业务层的实现类，对项目中的异常测试
 *
 */
public class UserServlceImpl {
    public void save(){
        //业务层中如果出现了异常，就对出现异常的代码进行try...catch...处理
        //在catch中将出现的异常包装成自定义异常，同时务必将当前异常对象传入自定义异常，避免真正的异常信息消失
        try {
            throw new SQLException();//把异常抛出去
        } catch (SQLException e) {
//            e.printStackTrace();//原来的方案
            throw new SystemException("数据库连接超时！",e);
            //把出现的异常包装成自定义的异常（这里是系统异常），同时还要把接收到的异常抛出去，避免弄丢
        }



    }
}
