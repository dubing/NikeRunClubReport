package com.nike.runclubreport.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/21/14.
 */
public interface IWeChatMessageService {
    void addListWeChatGroupMessage(Iterator<String> groupIdList,
                                   Iterator<String> messageIdList,
                                   List<Date> sendTimes,
                                   Iterator<String> message,
                                   List<Integer> messageTypes,
                                   Iterator<String> senderId);
}
