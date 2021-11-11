package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自己写一个异常处理器
 */
//@Component//被spring感知到
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {//形参同拦截器的形参
        /*
        这里不同与interceptor的无返回值，这里因为需要将发生的异常告知用户
        使用ModelAndView来作为返回值
        ModelAndView
        Web MVC 框架中模型和视图的持有者。 请注意，这些是完全不同的。
        这个类只是为了让控制器可以在单个返回值中同时返回模型和视图。
        表示由处理程序返回的模型和视图，由 DispatcherServlet 解析。
        视图可以采用字符串视图名称的形式，需要由 ViewResolver 对象解析；
        或者，可以直接指定 View 对象。 该模型是一个 Map，允许使用以名称为键的多个对象。
         */
        System.out.println("my exception is running ...."+ex);
        ModelAndView modelAndView = new ModelAndView();//这个对象是可以new出来的
        //判断不同类型的对象，分类讨论
        if( ex instanceof NullPointerException){
            //出现对应的错误，传递消息（向模型添加属性）
            modelAndView.addObject("msg","空指针异常");
        }else if ( ex instanceof  ArithmeticException){
            modelAndView.addObject("msg","算数运算异常");
        }else{
            modelAndView.addObject("msg","未知的异常");
        }
        modelAndView.setViewName("error.jsp");//跳转页面，在页面中接收到添加的消息
        return modelAndView;
    }
}
