package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * 之前的spring-mvc.xml是通过web.xml来加载的
 * <init-param>
 *      <param-name>contextConfigLocation</param-name>
 *      <param-value>classpath*:spring-mvc.xml</param-value>
 * </init-param>
 *
 * 这个类就代替了web.xml
 * servlet容器的初始化类
 */
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    /*
    创建Servlet容器时，使用注解的方式加载SPRINGMVC配置类中的信息（SpringMVCConfiguration.class），
    并加载成WEB专用的ApplicationContext对象
    该对象放入了ServletContext范围，后期在整个WEB容器中可以随时获取调用
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        //新建web环境专用的上下文对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();//注解配置版
        ctx.register(SpringMVCConfiguration.class);//注册
        return ctx;
    }

    //注解配置映射地址方式，服务于SpringMVC的核心控制器DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    //乱码处理作为过滤器，在servlet容器启动时进行配置，相关内容参看Servlet零配置相关课程
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {//启动时做的事情
        super.onStartup(servletContext);
        //在原始的功能上继续添加功能
        CharacterEncodingFilter cef = new CharacterEncodingFilter();//new一个字符集过滤器对象
        cef.setEncoding("UTF-8");
        FilterRegistration.Dynamic registration = servletContext.addFilter("characterEncodingFilter", cef);//这个过滤器是固定的名称
        //下面是映射的位置
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE),false,"/*");
    }
}

/*
这些了解一下就行，后续一般是配制文件加注解，不太使用纯注解的模式
 */