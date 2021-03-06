package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试返回json数据
 */
@Controller
public class AccountController {
    //使用原生response对象响应数据（不推荐使用这个）
    @RequestMapping("/showData1")
    public void showData1(HttpServletResponse response) throws IOException {//尽量断开与servlet的关联
        response.getWriter().write("message");
        /*
        返回一个可以向客户端发送字符文本的PrintWriter对象。
         */
    }

    //使用@ResponseBody将返回的结果作为响应内容，而非响应的页面名称
    @RequestMapping("/showData2")
    @ResponseBody//告知返回内容就是响应体
    public String showData2(){
        return "{'name':'Jock'}";
    }

    //使用jackson工具进行json数据格式转化
    @RequestMapping(value = "/showData3",produces = "application/json;charset=utf8")
    @ResponseBody
    public String showData3() throws JsonProcessingException {
        Book book  = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);

        ObjectMapper om = new ObjectMapper();//json构造函数
        return om.writeValueAsString(book);
    }

    //使用SpringMVC注解驱动（在spring-mvc.xml中添加），对标注@ResponseBody注解的控制器方法进行结果转换，由于返回值为引用类型，自动调用jackson提供的类型转换器进行格式转换
    @RequestMapping("/showData4")
    @ResponseBody
    public Book showData4() {
        Book book  = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);
        return book;
    }

    //转换集合类型数据
    @RequestMapping("/showData5")
    @ResponseBody
    public List showData5() {
        Book book1  = new Book();
        book1.setName("SpringMVC入门案例");
        book1.setPrice(66.66d);

        Book book2  = new Book();
        book2.setName("SpringMVC入门案例");
        book2.setPrice(66.66d);

        ArrayList al = new ArrayList();//容器
        al.add(book1);
        al.add(book2);
        return al;
        //[{"name":"SpringMVC入门案例","price":66.66},{"name":"SpringMVC入门案例","price":66.66}]
    }
}
