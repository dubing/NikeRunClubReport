package com.nike.runclubreport.persistence;

import com.nike.runclubreport.enumtypes.MessageType;

import java.util.Date;

/**
 * Created by bing.du on 4/23/14.
 */
public class WeChatMessage {
    private int id;
    private String weChatGroupId;
    private String messageId;
    private Date sendTime;
    private String message;
    private MessageType messageType;
    private String userName;
    private Date saveTime;

    public WeChatMessage(int id, String weChatGroupId, String messageId, Date sendTime, String message, MessageType messageType, String userName, Date saveTime) {
        this.id = id;
        this.weChatGroupId = weChatGroupId;
        this.messageId = messageId;
        this.sendTime = sendTime;
        this.message = message;
        this.messageType = messageType;
        this.userName = userName;
        this.saveTime = saveTime;
    }

    public String getWeChatGroupId() {
        return weChatGroupId;
    }

    public void setWeChatGroupId(String weChatGroupId) {
        this.weChatGroupId = weChatGroupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }
}
