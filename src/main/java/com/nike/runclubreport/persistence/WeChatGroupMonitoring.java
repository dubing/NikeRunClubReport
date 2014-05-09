package com.nike.runclubreport.persistence;

import java.util.Date;

/**
 * Created by bing.du on 4/30/14.
 */
public class WeChatGroupMonitoring {
    private int id;
    private String weChatGroupId;
    private int size;
    private String groupName;
    private int maleAmount;
    private int femaleAmount;
    private Date captureTime;
    private Date saveTime;

    public WeChatGroupMonitoring(int id, String weChatGroupId, int size,
                                 String groupName, int maleAmount, int femaleAmount, Date captureTime, Date saveTime) {
        this.id = id;
        this.weChatGroupId = weChatGroupId;
        this.size = size;
        this.groupName = groupName;
        this.maleAmount = maleAmount;
        this.femaleAmount = femaleAmount;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getMaleAmount() {
        return maleAmount;
    }

    public void setMaleAmount(int maleAmount) {
        this.maleAmount = maleAmount;
    }

    public int getFemaleAmount() {
        return femaleAmount;
    }

    public void setFemaleAmount(int femaleAmount) {
        this.femaleAmount = femaleAmount;
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
}
