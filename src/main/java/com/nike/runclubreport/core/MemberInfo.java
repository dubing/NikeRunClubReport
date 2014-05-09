package com.nike.runclubreport.core;

/**
 * Created by bing.du on 4/23/14.
 */

import com.google.gson.annotations.SerializedName;

public class MemberInfo {
    @SerializedName("username")
    private String userName;
    @SerializedName("nickname")
    private String nickName;
    @SerializedName("avator")
    private String avaTor;
    @SerializedName("gender")
    private int gender;
    @SerializedName("signature")
    private String signature;
    @SerializedName("location")
    private String location;
    @SerializedName("capturetime")
    private String captureTime;

    public MemberInfo(){}

    public MemberInfo(String userName, String nickName, String avaTor, int gender, String signature, String location, String captureTime) {
        this.userName = userName;
        this.nickName = nickName;
        this.avaTor = avaTor;
        this.gender = gender;
        this.signature = signature;
        this.location = location;
        this.captureTime = captureTime;
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

    public String getAvaTor() {
        return avaTor;
    }

    public void setAvaTor(String avaTor) {
        this.avaTor = avaTor;
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

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }
}
