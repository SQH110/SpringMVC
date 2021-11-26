package com.itheima.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.controller.results.Code;
import com.itheima.controller.results.Result;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.system.exection.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 表现层
 *
 * @author sqh
 * @create 2021-11-25
 */
@RestController//等于@Controller+@ResponseBody
@RequestMapping("/user")
public class UserController {

    //在Servlet上下文环境中加入Spring的配置文件，就可以使用Spirng中定义的bean了
    @Autowired
    private UserService userService;

    //新增使用post
    @PostMapping//什么都不用传递，是以一个表单提交的方式
    public Result save(User user) {
//        System.out.println("save..." + user);
        boolean flag = userService.save(user);
        //不止知道是否成功，还能知道是哪种操作
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERROR);
    }

    //修改使用put
    @PutMapping//
    public Result update(User user) {
//        System.out.println("update..." + user);
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERROR);
    }

    @DeleteMapping("/{uuid}")
    public Result delete(@PathVariable Integer uuid) {
//        System.out.println("delete..." + uuid);
        boolean flag = userService.delete(uuid);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERROR);
    }

    //按照rest风格
    //查询单个
    @GetMapping("/{uuid}")
    public Result get(@PathVariable Integer uuid) {//需要从路径中获取id值
//        System.out.println("get..." + uuid);
        User user = userService.get(uuid);
        //假设抛出一个异常
        if (uuid == 10) throw new BusinessException("查询出错了，请重试！",Code.GET_ERROR);

        return new Result(null != user ?Code.GET_OK : Code.GET_ERROR , user);
    }

    //全部查询
    @GetMapping("/{page}/{size}")
    public Result getAll(@PathVariable Integer page ,@PathVariable Integer size) {//传两个参数，一个第几页，一个每页几条
//        System.out.println("getAll..." + page + "," + size);
        PageInfo<User> all = userService.getAll(page, size);
//        System.out.println(all);
        return new Result(null != all ?Code.GET_OK : Code.GET_ERROR , all);
    }

    //登录功能（其实就是登录查询）
    @PostMapping("/login")//虽然也是查询，但是这种加密的
    //这个/login是为了和普通的post新增区别开来
    public Result login(String userName,String password) {
//        System.out.println("login..." + userName + "," + password);
        User user = userService.login(userName, password);
        return new Result(null != user ?Code.GET_OK : Code.GET_ERROR , user);
    }
}

