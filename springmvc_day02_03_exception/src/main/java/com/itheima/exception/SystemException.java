package com.itheima.exception;
/*
异常处理解决方案
自定义异常--系统异常：传递消息给用户，安抚；提醒运维维护；日志
 */
//自定义异常继承RuntimeException，覆盖父类所有的构造方法
public class SystemException extends RuntimeException {
    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
