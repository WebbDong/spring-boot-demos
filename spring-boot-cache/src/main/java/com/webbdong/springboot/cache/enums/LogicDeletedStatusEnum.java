package com.webbdong.springboot.cache.enums;

public enum LogicDeletedStatusEnum {

    NOT_DELETED(0, "未删除"),
    DELETED(1, "已删除"),
    ;

    LogicDeletedStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private int code;

    private String name;

}
