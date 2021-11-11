package com.itheima.controller.results;

/**
 * 数据的格式设计---统一格式给前端
 *
 * @author sqh
 * @create 2021-06-08
 */
public class Result {
    //操作结果编码（状态）
    private Integer code;

    //操作数据结果（数据）
    private Object data;

    //消息
    private String message;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, Object data) {//用于还有数据传出
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String message) {//用于异常情况
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", date=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getDate() {
        return data;
    }

    public void setDate(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
