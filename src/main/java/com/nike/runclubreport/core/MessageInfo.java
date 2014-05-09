package com.nike.runclubreport.core;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bing.du on 4/23/14.
 */
public class MessageInfo {
    @SerializedName("messageid")
    private String messageId;
    @SerializedName("sendtime")
    private String sendTime;
    @SerializedName("content")
    private String content;
    @SerializedName("messagetype")
    private int messageType;
    @SerializedName("senderusername")
    private String senderUsername;

    public MessageInfo(){}

    public MessageInfo(String messageId, String sendTime, String content, int messageType, String senderUsername) {
        this.messageId = messageId;
        this.sendTime = sendTime;
        this.content = content;
        this.messageType = messageType;
        this.senderUsername = senderUsername;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }
}
