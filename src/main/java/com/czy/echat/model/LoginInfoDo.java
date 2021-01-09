package com.czy.echat.model;

import java.util.Date;

/**
 * @author MccreeFei
 * @create 2018-04-28 下午1:32
 */
public class LoginInfoDo {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer status;
    private Date createTime;

    public LoginInfoDo() {
    }

    public LoginInfoDo(Integer id, Integer userId, String userName, Integer status, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.createTime = createTime;
    }

    public static LoginInfoBuilder builder(){
        return new LoginInfoBuilder();
    }

    public static class LoginInfoBuilder{
        private Integer id;
        private Integer userId;
        private String userName;
        private Integer status;
        private Date createTime;

        public LoginInfoBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public LoginInfoBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public LoginInfoBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public LoginInfoBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public LoginInfoBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public LoginInfoDo build(){
            return new LoginInfoDo(id, userId, userName, status, createTime);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
