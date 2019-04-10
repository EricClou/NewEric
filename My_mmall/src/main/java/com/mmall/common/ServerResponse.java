package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by geely
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse ( int status ) {
        this.status = status;
    }

    private ServerResponse ( int status, T data ) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse ( int status, String msg, T data ) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse ( int status, String msg ) {
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess () {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus () {
        return status;
    }

    public T getData () {
        return data;
    }

    public String getMsg () {
        return msg;
    }


    /**
     * @return 以下这些静态方法调用构造器。
     * 首先分为Success和Error两类，这两类的分辨首先在Service层由代码逻辑就可以判定出来了，
     * 那么这里只要名字上带有success的，在调用构造器的时候就把status设置成success.code。error的情况同理
     */

    public static <T> ServerResponse <T> createBySuccess () {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse <T> createBySuccessMessage ( String msg ) {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse <T> createBySuccess ( T data ) {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse <T> createBySuccess ( String msg, T data ) {
        return new ServerResponse <T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> ServerResponse <T> createByError () {
        return new ServerResponse <T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }


    public static <T> ServerResponse <T> createByErrorMessage ( String errorMessage ) {
        return new ServerResponse <T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse <T> createByErrorCodeMessage ( int errorCode, String errorMessage ) {
        return new ServerResponse <T>(errorCode, errorMessage);
    }


}
