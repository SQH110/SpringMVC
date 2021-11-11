package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 主处理器
 */
@Controller
public class InterceptorController {
    @RequestMapping("/handleRun")//虚拟路径
    public String handleRun() {
        System.out.println("业务处理器运行------------main");
        return "page.jsp";
    }
}
