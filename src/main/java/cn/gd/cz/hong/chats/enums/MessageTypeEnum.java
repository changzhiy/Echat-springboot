package cn.gd.cz.hong.chats.enums;

/**
 * @author hong
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
