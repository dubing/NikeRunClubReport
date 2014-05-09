package com.nike.runclubreport.persistence;

import java.util.Date;

/**
 * Created by bing.du on 4/24/14.
 */
public class WeChatMember {
    private int id;
    private String userName;
    private String nickName;
    private String avator;
    private int gender;
    private String signature;
    private String location;
    private Date captureTime;
    private Date saveTime;

    public WeChatMember(int id, String userName, String nickName, String avator, int gender, String signature, String location, Date captureTime, Date saveTime) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.avator = avator;
        this.gender = gender;
        this.signature = signature;
        this.location = location;
        this.captureTime = captureTime;
        this.saveTime = saveTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
