package com.nike.runclubreport.core;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by bing.du on 4/23/14.
 */
public class GroupMessages {
    @SerializedName("conversations")
    private List<Conversation> conversations;

    public GroupMessages() {
    }

    public GroupMessages(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}
