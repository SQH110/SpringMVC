package com.itheima.controller.intercepter;

import com.itheima.controller.results.Code;
import com.itheima.controller.results.Result;
import com.itheima.system.exection.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目异常处理的增强
 *
 * @author sqh
 * @create 2021-11-26
 */
@Component
@ControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)//异常拦截处理
    @ResponseBody//返回字符串而不是页面
    public Result doBusinessException(BusinessException e) {
        return new Result(e.getCode(),e.getMessage());
    }
}
