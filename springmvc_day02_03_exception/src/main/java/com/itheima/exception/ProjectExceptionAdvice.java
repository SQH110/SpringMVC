package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
安照之前的注解的异常处理，来做一个项目的异常处理
 */
@Component
@ControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)//换一个捕获类型
    public String doBusinessException(Exception ex, Model m){
        //使用参数Model将要保存的数据传递到页面上，功能等同于ModelAndView
        //业务异常出现的消息要发送给用户查看
        //ex.getMessage()：就是把异常消息放入
        m.addAttribute("msg",ex.getMessage());
        //addAttribute(就是在提供的名称下添加提供的属性

        return "error.jsp";//返回一个页面，不用@ResponseBody了

    }

    @ExceptionHandler(SystemException.class)
    public String doSystemException(Exception ex, Model m){
        //系统异常出现的消息不要发送给用户查看，发送统一的信息给用户看(安抚用户)
        m.addAttribute("msg","服务器出现问题，请联系管理员！");
        //实际的问题现象应该传递给redis服务器，运维人员通过后台系统查看
        //实际的问题显现更应该传递给redis服务器，运维人员通过后台系统查看
        return "error.jsp";
    }

    @ExceptionHandler(Exception.class)
    public String doException(Exception ex, Model m){
        m.addAttribute("msg",ex.getMessage());
        //将ex对象保存起来（记录日志）
        return "error.jsp";
    }

}
