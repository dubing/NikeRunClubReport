package com.nike.runclubreport.persistence;

import java.util.Date;

/**
 * Created by bing.du on 4/28/14.
 */
public class WeChatGroupMemberShip {
    private int id;
    private String weChatGroupId;
    private String userName;
    private Date saveTime;

    public WeChatGroupMemberShip(int id, String weChatGroupId, String userName, Date saveTime) {
        this.id = id;
        this.weChatGroupId = weChatGroupId;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }
}
