package com.nike.runclubreport.persistence;

import java.util.Date;

/**
 * Created by bing.du on 4/21/14.
 */
public class WeChatGroup {
    private int id;
    private String weChatGroupId;
    private String weChatGroupName;
    private int size;
    private String signature;
    private Date captureTime;
    private Date saveTime;

    public WeChatGroup(int id, String weChatGroupId, String weChatGroupName, int size, String signature, Date captureTime, Date saveTime) {
        this.id = id;
        this.weChatGroupId = weChatGroupId;
        this.weChatGroupName = weChatGroupName;
        this.size = size;
        this.signature = signature;
        this.captureTime = captureTime;
        this.saveTime = saveTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
