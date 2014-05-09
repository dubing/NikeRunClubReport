package com.nike.runclubreport.persistence;

import java.util.Date;

/**
 * Created by bing.du on 5/5/14.
 */
public class WeChatListeningMatchedMessage {
    private int id;
    private int keywordsId;
    private String messageId;
    private Date saveTime;

    public WeChatListeningMatchedMessage(int id, int keywordsId, String messageId, Date saveTime) {
        this.id = id;
        this.keywordsId = keywordsId;
        this.messageId = messageId;
        this.saveTime = saveTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKeywordsId() {
        return keywordsId;
    }

    public void setKeywordsId(int keywordsId) {
        this.keywordsId = keywordsId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }
}
