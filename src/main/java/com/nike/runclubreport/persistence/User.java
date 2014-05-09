package com.nike.runclubreport.persistence;

import org.joda.time.DateTime;

/**
 * Created by andrew.bao on 4/30/14.
 */
public class User {
    private final int id;
    private final String userName;
    private final String displayName;
    private final int type;
    private final DateTime saveTime;
    private final String password;

    public User(int id, String userName, String displayName, int type, DateTime saveTime, String password){
        this.id = id;
        this.userName = userName;
        this.displayName = displayName;
        this.type = type;
        this.saveTime = saveTime;
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public DateTime getSaveTime() {
        return saveTime;
    }

    public String getPassword() {
        return password;
    }
}
