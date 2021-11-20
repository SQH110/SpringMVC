package com.itheima.controller.interceptor;

import com.itheima.controller.results.Result;
import com.itheima.system.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目异常增强处理器
 * @author sqh
 * @create 2021-06-09
 */
@Component//是spring控制的bean
@ControllerAdvice//是Controller的增强处理器
public class ProjectExceptionAdvice {
    @ExceptionHandler(BusinessException.class)//用于拦截对应异常
    @ResponseBody//不跳转页面
    public Result doBusinessException(BusinessException e) {
//        return e.getMessage();//需要统一数据格式（result对象）
        return new Result(e.getCode(),e.getMessage());
    }

}
