package com.nike.runclubreport.persistence;

import java.util.Date;

/**
 * Created by bing.du on 4/22/14.
 */
public class Keyword {
    private int id;
    private String keywords;
    private Date startTime;
    private Date endTime;
    private Date saveTime;

    public Keyword(int id, String keywords, Date startTime, Date endTime, Date saveTime) {
        this.id = id;
        this.keywords = keywords;
        this.startTime = startTime;
        this.endTime = endTime;
        this.saveTime = saveTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }
}
