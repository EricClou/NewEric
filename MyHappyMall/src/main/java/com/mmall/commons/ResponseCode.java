package com.mmall.commons;

public enum ResponseCode {
    ERROR(1, "ERROR"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    SUCCESS(0, "SUCCESS");

    private final int code;
    private final String desc;

    ResponseCode ( int code, String desc ) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode () {
        return this.code;
    }

    public String getDesc () {
        return this.desc;
    }
}
