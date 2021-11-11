package com.itheima.system.exception;

/**
 * 自定义异常使用处理器处理
 *
 *
 * @author sqh
 * @create 2021-06-09
 */
public class BusinessException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code) {
        this.code = code;
    }

    public BusinessException(String message,Integer code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause,Integer code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause,Integer code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
