package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
使用注解开发异常处理器，实现了异常的分类管理。
 这是一个通知类
 */
//@Component//被spring控制

//声明该类是一个Controller的通知类，声明后该类就会被加载成异常处理器
//@ControllerAdvice//这就可以在controller前后做功能增强了
public class ExceptionAdvice {

    //类中定义的方法携带@ExceptionHandler注解的会作为异常处理器，后面添加实际处理的异常类型
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody//只要回复字符串，不解析为页面
    public String doNullException(Exception ex){//这里的形参可以拿到原来异常的对象
        return "空指针异常";//这个类似于controller功能（@controller）对页面输出，这里用@ResponseBody
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//如果不加，认为跳转到/ArithmeticException这个域名下
    public String doArithmeticException(Exception ex){
        return "ArithmeticException";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String doException(Exception ex){
        return "all";
    }
/**
 * 谈一下自定义异常处理器（通过实现HandlerExceptionResolver接口的）与注解格式的不同
 * 第一种：是在Controller接收完数据后才工作的，加载的比较晚
 * 而使用注解格式的加载时间发生在DispatcherServlet后，加载比较早，可以拦截参数中发现的异常
 * 选用注解更好
 */


}
