package com.nike.runclubreport.model;

/**
 * Created by andrew.bao on 4/24/14.
 */
public class ReportUser {
    private final String username;
    private final String password;
    private final ReportUserType userType;

    public ReportUser(final String username, final String password, final ReportUserType userType){
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public ReportUserType getUserType() {
        return this.userType;
    }
}
