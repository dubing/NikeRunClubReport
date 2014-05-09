package com.nike.runclubreport.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/29/14.
 */
public class BatchParams {
    private String weChatGroupId;
    private String weChatGroupName;
    private int size;
    private int maleAmount;
    private int femaleAmount;
    private Date captureTime;
    private String newSignature;
    private List<String> exitGroupMembers;
    private MemberBatchParams memberBatchParams;
    private MemberShipBatchParams memberShipBatchParams;
    private MessageBatchParams messageBatchParams;
    private MatchMessageBatchParams matchMessageBatchParams;

    public BatchParams() {
        exitGroupMembers = new ArrayList<>();
        memberBatchParams = new MemberBatchParams();
        memberShipBatchParams = new MemberShipBatchParams();
        messageBatchParams = new MessageBatchParams();
        matchMessageBatchParams = new MatchMessageBatchParams();
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

    public String getWeChatGroupId() {
        return weChatGroupId;
    }

    public void setWeChatGroupId(String weChatGroupId) {
        this.weChatGroupId = weChatGroupId;
    }

    public MemberBatchParams getMemberBatchParams() {
        return memberBatchParams;
    }

    public MemberShipBatchParams getMemberShipBatchParams() {
        return memberShipBatchParams;
    }

    public MessageBatchParams getMessageBatchParams() {
        return messageBatchParams;
    }

    public MatchMessageBatchParams getMatchMessageBatchParams() {
        return matchMessageBatchParams;
    }

    public List<String> getExitGroupMembers() {
        return exitGroupMembers;
    }

    public void setExitGroupMembers(List<String> exitGroupMembers) {
        this.exitGroupMembers = exitGroupMembers;
    }

    public String getNewSignature() {
        return newSignature;
    }

    public void setNewSignature(String newSignature) {
        this.newSignature = newSignature;
    }
}
