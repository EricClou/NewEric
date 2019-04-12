package com.mmall.commons;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    public ServerResponse ( int status ) {
        this.status = status;
    }


    public ServerResponse ( int status, String msg ) {
        this.status = status;
        this.msg = msg;
    }

    public ServerResponse ( int status, T data ) {
        this.status = status;
        this.data = data;
    }


    public ServerResponse ( int status, String msg, T data ) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    //使其不在json的序列化结果中
    public boolean isSuccess () {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus () {
        return this.status;
    }

    public String getMsg () {
        return this.msg;
    }

    public T getData () {
        return this.data;
    }

    //当前操作成功，
    public static <T> ServerResponse <T> createBySuccess () {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse <T> createBySuccessMessage ( String msg ) {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse <T> createBySuccess ( String msg, T data ) {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse <T> createBySuccess ( T data ) {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode(), data);
    }


    //当前操作失败
    public static <T> ServerResponse <T> createByError () {
        return new ServerResponse <T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse <T> createByErrorMessage ( String errorMsg ) {
        return new ServerResponse <T>(ResponseCode.ERROR.getCode(), errorMsg);
    }


    public static <T> ServerResponse <T> createByErrorCodeMessage ( int errorCode, String errorMsg ) {
        return new ServerResponse <T>(errorCode, errorMsg);
    }


}
