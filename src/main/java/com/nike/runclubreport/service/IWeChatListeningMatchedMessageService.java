package com.nike.runclubreport.service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 5/6/14.
 */
public interface IWeChatListeningMatchedMessageService {
    void addMatchedMessages(List<Integer> keywordsList,Iterator<String> messageIdList);
}
