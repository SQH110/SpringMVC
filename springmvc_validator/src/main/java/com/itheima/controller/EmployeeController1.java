package com.itheima.controller;

import com.itheima.controller.groups.GroupA;
import com.itheima.domain.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import javax.validation.Valid;
import java.util.List;

/**
 * 表单校验
 */
@Controller
public class EmployeeController1 {
//************************分组校验****************************************
    @RequestMapping(value = "/addemployee")//接收到表单中的数据
    //要求使用@Validated()，便于分组校验（由springmvc提供）(下面只对GroupA.class校验)
    public String addEmployee1(@Validated(value = {GroupA.class}) Employee employee,Errors errors,Model m) {//把数据封装到Employee employee
        /*
        校验需要@Valid（javax.validation.Valid：jsr303规范下的）
        或者@Validated （spring提供的org.springframework.validation.annotation.Validated）

        这个errors用来保存你所有的问题现象，这个是spring框架提供的
         */

//        System.out.println(errors.hasErrors());//这个用来返回是否有问题（有故障就是true）
        if(errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();//获取与字段相关的所有错误
            System.out.println(fieldErrors.size());//打印到拦截errors的数量
            for(FieldError error : fieldErrors) {
                System.out.println(error.getField());//name，错误的field
                System.out.println(error.getDefaultMessage());//姓名不能为空，错误对应的信息
                System.out.println("------下一个-----");
                /*
                考虑把信息反馈出去，告知用户，利用一个形参model
                 */
                m.addAttribute(error.getField(), error.getDefaultMessage());
                //addAttribute(在提供的名称下添加提供的属性
            }
            return "addemployee.jsp";//当遇到问题的时候，回到原来的界面并且说明错误
        }
        return "success.jsp";
    }

//**********************************************************************************************
    @RequestMapping(value = "/addemployee3")//接收到表单中的数据
    public String addEmployee(@Valid Employee employee,Errors errors,Model m) {//把数据封装到Employee employee
        /*
        校验需要@Valid（javax.validation.Valid：jsr303规范下的）
        或者@Validated （spring提供的org.springframework.validation.annotation.Validated）

        这个errors用来保存你所有的问题现象，这个是spring框架提供的
         */

//        System.out.println(errors.hasErrors());//这个用来返回是否有问题（有故障就是true）
        if(errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();//获取与字段相关的所有错误
            System.out.println(fieldErrors.size());//打印到拦截的数量
            for(FieldError error : fieldErrors) {
                System.out.println(error.getField());//name，错误的field
                System.out.println(error.getDefaultMessage());//姓名不能为空，错误对应的信息
                /*
                考虑把信息反馈出去，告知用户，利用一个形参model
                 */
                m.addAttribute(error.getField(), error.getDefaultMessage());
                //addAttribute(在提供的名称下添加提供的属性
            }
            return "addemployee.jsp";//当遇到问题的时候，回到原来的界面并且说明错误
        }
        return "success.jsp";
    }






}