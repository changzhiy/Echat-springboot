package com.czy.echat.model;

import java.util.Date;

/**
 * @author MccreeFei
 * @create 2018-04-28 下午1:35
 */
public class MessageRecordDo {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer messageType;
    private String content;
    private Date createTime;

    public MessageRecordDo() {
    }

    public MessageRecordDo(Integer id, Integer userId, String userName, Integer messageType, String content, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.messageType = messageType;
        this.content = content;
        this.createTime = createTime;
    }

    public static MessageRecordBuilder messageRecordBuilder(){
        return new MessageRecordBuilder();
    }

    public static class MessageRecordBuilder{
        private Integer id;
        private Integer userId;
        private String userName;
        private Integer messageType;
        private String content;
        private Date createTime;

        public MessageRecordBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public MessageRecordBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public MessageRecordBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public MessageRecordBuilder messageType(Integer messageType) {
            this.messageType = messageType;
            return this;
        }

        public MessageRecordBuilder content(String content) {
            this.content = content;
            return this;
        }

        public MessageRecordBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public MessageRecordDo build(){
            return new MessageRecordDo(id, userId, userName, messageType, content, createTime);
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

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
