package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.controller.results.Code;
import com.itheima.controller.results.Result;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.system.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * restful风格配置
 * 隐藏资源的访问行为
 * get：查询
 * post：保存
 * put：更新
 * delete：删除
 *
 *
 *
 * @author sqh
 * @create 2021-06-05
 */
//@Controller
//@ResponseBody
@RestController//综合两个（是rest风格的controller也是bean）
@RequestMapping("/user")//公共映射路径
public class UserController {

    @Autowired
//    @Qualifier("userservice")//注入后就可以调用service
    private UserService userService;

    @PostMapping//新增：用post请求的方式（这里什么都不用填，用表单提交）
    public Result save(User user) {
        boolean flag = userService.save(user);
        //封装结果，根据结果不同返回不同的东西
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERROR);
    }

    @PutMapping//修改：用put提交（这里什么都不用填，用表单提交）
    public Result update(User user) {
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERROR);
    }

    @DeleteMapping("{uuid}")//删除使用id删除，需要uuid
    public Result delete(@PathVariable Integer uuid) {
        boolean flag = userService.delete(uuid);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERROR);
    }

    @GetMapping("/{uuid}")//rest风格用get提交，这个uuid要传给下面的形参，是从路径中取得变量
    //@PathVariable：获取路径上配置的具名变量，该配置可以使用多次
    public Result get (@PathVariable Integer uuid) {
        User user = userService.get(uuid);
        //假设这里有一个异常
        if(uuid == 10) {
            throw new BusinessException("查询出错了，请重试！",Code.GET_ERROR);
        }
        return new Result(null != user ? Code.GET_OK:Code.GET_ERROR,user);//是否返回空对象
    }

    @GetMapping("/{page}/{size}")//分页查询
    public Result getAll (@PathVariable Integer page, @PathVariable Integer size) {
        PageInfo<User> all = userService.getAll(page, size);
        return new Result(null != all ? Code.GET_OK:Code.GET_ERROR,all);
    }

    @PostMapping("/login")//密码啥的不能用明文，所以需要使用post（rest是一个风格），另外和save的路径要区分
    public Result login(String userName,String password) {//会把表单中的值配给形参
        User login = userService.login(userName, password);
        return new Result(null != login ? Code.GET_OK:Code.GET_ERROR,login);
    }


}
