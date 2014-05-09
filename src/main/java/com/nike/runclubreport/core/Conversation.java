package com.nike.runclubreport.core;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by bing.du on 4/23/14.
 */
public class Conversation {
    @SerializedName("wechatgroupid")
    private String weChatGroupId;
    @SerializedName("wechatgroupname")
    private String weChatGroupName;
    @SerializedName("capturetime")
    private String captureTime;
    @SerializedName("members")
    List<MemberInfo> Members;
    @SerializedName("messages")
    List<MessageInfo> Messages;

    public Conversation() {
    }

    public Conversation(String weChatGroupId, String weChatGroupName, String captureTime, List<MemberInfo> memberInfos, List<MessageInfo> messageInfos) {
        this.weChatGroupId = weChatGroupId;
        this.weChatGroupName = weChatGroupName;
        this.captureTime = captureTime;
        Members = memberInfos;
        Messages = messageInfos;
    }

    public String getWeChatGroupId() {
        return weChatGroupId;
    }

    public void setWeChatGroupId(String weChatGroupId) {
        this.weChatGroupId = weChatGroupId;
    }

    public String getWeChatGroupName() {
        return weChatGroupName;
    }

    public void setWeChatGroupName(String weChatGroupName) {
        this.weChatGroupName = weChatGroupName;
    }

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }

    public List<MemberInfo> getMembers() {
        return Members;
    }

    public void setMembers(List<MemberInfo> Members) {
        this.Members = Members;
    }

    public List<MessageInfo> getMessages() {
        return Messages;
    }

    public void setMessages(List<MessageInfo> Messages) {
        this.Messages = Messages;
    }
}

