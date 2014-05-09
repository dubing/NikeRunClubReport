package com.nike.runclubreport.enumtypes;

/**
 * Created by bing.du on 4/23/14.
 */
public enum MessageType {
    Image(0),
    Text(1),
    Voice(2);

    private int value = 0;

    private MessageType(int value) {
        this.value = value;
    }

    public static MessageType valueof(int value) {
        switch (value) {
            case 0:
                return Image;
            case 1:
                return Text;
            case 2:
                return Voice;
            default:
                return null;
        }
    }

    public int value() {
        return this.value;
    }

}