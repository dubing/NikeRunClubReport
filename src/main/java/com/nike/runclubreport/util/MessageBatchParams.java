package com.nike.runclubreport.util;

import com.nike.runclubreport.core.MessageInfo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/25/14.
 */
public class MessageBatchParams {
    private List<String> groupIdList;
    private List<String> messageIdList;
    private List<Date> sendTimes;
    private List<String> message;
    private List<Integer> messageTypes;
    private List<String> userNameList;

    public MessageBatchParams() {
        groupIdList = new ArrayList<>();
        messageIdList = new ArrayList<>();
        sendTimes = new ArrayList<>();
        message = new ArrayList<>();
        messageTypes = new ArrayList<>();
        userNameList = new ArrayList<>();
    }

    public void addParam(String groupId, MessageInfo weChatMessage, String username) throws ParseException {
        groupIdList.add(groupId);
        messageIdList.add(weChatMessage.getMessageId());
        sendTimes.add(ParamFormat.ConvertStringToDate(weChatMessage.getSendTime()));
        message.add(weChatMessage.getContent());
        messageTypes.add(weChatMessage.getMessageType());
        userNameList.add(username);
    }

    public List<String> getGroupIdList() {
        return groupIdList;
    }

    public List<String> getMessageIdList() {
        return messageIdList;
    }

    public List<Date> getSendTimes() {
        return sendTimes;
    }

    public List<String> getMessage() {
        return message;
    }

    public List<Integer> getMessageTypes() {
        return messageTypes;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }
}
