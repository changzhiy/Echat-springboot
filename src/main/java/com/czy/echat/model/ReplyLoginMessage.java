package com.czy.echat.model;

/**
 * 反馈前端ajax登录的信息实体
 */
public class ReplyLoginMessage {
    public static final Integer USER_NAME_NOT_EXIST = 1; //当前登录的用户名尚未注册
    public static final Integer USER_PASSWORD_WRONG = 2; //登录密码错误
    public static final Integer USER_NAME_OR_PASSWORD_NULL = 3; //用户姓名或密码未填写
    private boolean successed;  //登录是否成功
    private Integer errStatus;  //错误原因

    public ReplyLoginMessage(boolean successed) {
        this.successed = successed;
    }

    public ReplyLoginMessage(boolean successed, Integer errStatus) {
        this.successed = successed;
        this.errStatus = errStatus;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public Integer getErrStatus() {
        return errStatus;
    }

    public void setErrStatus(Integer errStatus) {
        this.errStatus = errStatus;
    }
}
