package com.nike.runclubreport.model;

/**
 * Created by andrew.bao on 4/24/14.
 */
public enum ReportUserType {
    UNKNOWN(0),
    ADMIN(1),
    CM(2);

    private final int value;

    private ReportUserType(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
