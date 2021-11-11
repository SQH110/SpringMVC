package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//代替spring-mvc.xml
@ComponentScan(value = "com.itheima",includeFilters =//指定一个过滤器
    @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class})
        //指定来源的类型（是注解），和对应的注解.class
    )
public class SpringMVCConfiguration implements WebMvcConfigurer{//替换xml中的放行指定类型静态资源配置方式
    //注解配置放行指定资源格式
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //指定资源以及访问路径
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//    }

    //注解配置通用放行资源的格式
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
