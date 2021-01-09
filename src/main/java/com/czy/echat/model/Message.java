package com.czy.echat.model;

import java.util.Date;

/**
 * 用户发送消息的实体
 */
public class Message {
    private String userName;  //发送者
    private Date sendDate;    //发送日期
    private String content;   //发送内容
    private String messageType;//发送消息类型（“text”文本，“image”图片）

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userName='" + userName + '\'' +
                ", sendDate=" + sendDate +
                ", content='" + content + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
