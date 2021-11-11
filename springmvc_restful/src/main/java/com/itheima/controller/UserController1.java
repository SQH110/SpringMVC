package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@Controller
//@ResponseBody
//上边两个注解合并为一个新的
@RestController//它其实也是一种controller风格的配置
@RequestMapping("/user/")
public class UserController1 {


    @RequestMapping("/restLocation")
    public String restLocation(){
        System.out.println("restful is running ....");
        return "success.jsp";
    }

    //*********************修改为rest风格*********************************

    @RequestMapping(value = "{id}")//格式变成/user/1这种
    public String restLocation(@PathVariable Integer id){//用形参来接着id(在路径中接)
        System.out.println("restful is running ....get:" + id);
        return "success.jsp";
        //可以发现它访问webapp下对应/user下的success.jsp(进一步改到@RequestMapping("/user/"))
        //但是对于我们来说，不需要网页的导向，而是直接的数据（用@ResponseBody）
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String get(@PathVariable Integer id){//get：查询
        System.out.println("restful is running ....get:" + id);
        return "success.jsp";
    }


    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public String post(@PathVariable Integer id){//post：保存
        System.out.println("restful is running ....post:" + id);
        return "success.jsp";
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public String put(@PathVariable Integer id){//put：更新
        System.out.println("restful is running ....put:" + id);
        return "success.jsp";
    }

//    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    @DeleteMapping(value = "{id}")//简化的配置
    public String delete(@PathVariable Integer id){//delete：删除
        System.out.println("restful is running ....delete:" + id);
        return "success.jsp";
    }

}

