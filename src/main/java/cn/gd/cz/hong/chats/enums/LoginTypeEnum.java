package cn.gd.cz.hong.chats.enums;

/**
 * @author hong
 */
public enum LoginTypeEnum {
    LOGIN(1, "上线"),
    LOGOUT(2, "下线");
    private int code;
    private String desc;

    LoginTypeEnum(int code, String desc) {
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
