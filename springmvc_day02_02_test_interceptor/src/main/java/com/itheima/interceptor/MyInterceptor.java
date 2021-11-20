package com.itheima.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//自定义拦截器需要实现HandleInterceptor接口
public class MyInterceptor implements HandlerInterceptor {
    //处理器运行之前执行
    /*
    说一下这里的几个形参：
    HttpServletRequest request
    HttpServletResponse response
    当mvc的处理器handle要对请求和响应做一些操作时，需要借助这两个对象
    Object handler
    被调用的处理器对象，当你想要操作与原始方法相关的东西，就要借助这个对象
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("前置运行----a1");
        //返回值为false将拦截原始处理器的运行
        //如果配置多拦截器，返回值为false将终止当前拦截器后面配置的拦截器的运行
        return true;
    }

    //处理器运行之后执行
    /*
    ModelAndView modelAndView
    这个是handle运行完返回的东西，原始的控制器最终返回包装为一个modelAndView对象
    一般返回有model和view，所以叫做modelAndView。
    这里的modelAndView可以修改最终返回的页面（干坏事）
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("后置运行----b1");
    }

    //所有拦截器的后置执行全部结束后，执行该操作
    /*
    Exception ex
    万一主处理器抛了异常，这里可以拦截异常，单独处理
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("完成运行----c1");
    }

    //三个方法的运行顺序为    preHandle -> postHandle -> afterCompletion
    //如果preHandle返回值为false，三个方法仅运行preHandle
}
