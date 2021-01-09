package com.czy.echat.model;

/**
 * 反馈前端ajax注册的消息实体
 */
public class ReplyRegistMessage {
    public static final Integer USER_NAME_EXIST = 1; //注册名已经存在
    private boolean successed;  //是否注册成功
    private Integer errStatus;  //错误原因

    public ReplyRegistMessage(boolean isSuccessed) {
        this.successed = isSuccessed;
    }

    public ReplyRegistMessage(boolean isSuccessed, Integer errStatus) {
        this.successed = isSuccessed;
        this.errStatus = errStatus;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        successed = successed;
    }

    public Integer getErrStatus() {
        return errStatus;
    }

    public void setErrStatus(Integer errStatus) {
        this.errStatus = errStatus;
    }
}
