package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//代替spring-mvc.xml配置文件（负责SpringMVC的bean加载和通用资源放行）
@ComponentScan(value = "com.itheima", includeFilters =//指定一个过滤器
@ComponentScan.Filter(//指定来源的类型（是注解），和对应的注解.class
        type = FilterType.ANNOTATION,
        classes = {Controller.class})
)
public class SpringMVCConfiguration implements WebMvcConfigurer {//替换xml中的放行指定类型静态资源配置方式
    /*
        实现这个接口可以不用实现什么方法
        但是要满足自己的需求就要选择性的实现一些方法，覆盖默认提供的方法
     */

    //注解配置放行指定资源格式
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////    指定资源以及访问路径
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
