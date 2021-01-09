package com.czy.echat.enums;

/**
 * @author MccreeFei
 * @create 2018-04-28 下午1:30
 */
public enum MessageTypeEnum {
    TEXT(1, "text"),
    IMAGE(2, "image");
    private int code;
    private String desc;

    MessageTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
