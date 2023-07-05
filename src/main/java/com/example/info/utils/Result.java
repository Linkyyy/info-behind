package com.example.info.utils;

public class Result {
    private Integer code;
    private String message;

    private Result(){

    }

    private Object data=new Object();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result data(Object value){
        this.data=value;
        return this;
    }
    public Result message(String message){
        this.message=message;
        return this;
    }
    public Result code(int code){
        this.code=code;
        return this;
    }

    public static Result ok(){
        Result r=new Result();
        r.setCode(20000);
        r.setMessage("成功！");
        return r;
    }

    public static Result error(){
        Result r=new Result();
        r.setCode(0);
        r.setMessage("失败！");
        return r;
    }

}
