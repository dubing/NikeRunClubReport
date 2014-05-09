package com.nike.runclubreport.model;

import com.nike.runclubreport.persistence.User;

/**
 * Created by andrew.bao on 4/30/14.
 */
public class LoginResult {
    private final boolean isSucceed;
    private final String errorCode;
    private final User user;

    public LoginResult(boolean isSucceed, LoginErrorCode errorCode, User user){
        this.isSucceed = isSucceed;
        this.errorCode = errorCode.toString();
        this.user = user;
    }

    public boolean isSucceed() {
        return isSucceed;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public User getUser() {
        return user;
    }
}
