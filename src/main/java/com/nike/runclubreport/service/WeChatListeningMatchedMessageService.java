package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.IWeChatListeningMatchedMessageDAO;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 5/6/14.
 */
public class WeChatListeningMatchedMessageService implements IWeChatListeningMatchedMessageService {
    private final IWeChatListeningMatchedMessageDAO weChatListeningMatchedMessageDAO;

    @Inject
    public WeChatListeningMatchedMessageService(final IWeChatListeningMatchedMessageDAO weChatListeningMatchedMessageDAO) {
        this.weChatListeningMatchedMessageDAO = weChatListeningMatchedMessageDAO;
    }

    public void addMatchedMessages(List<Integer> keywordsList,Iterator<String> messageIdList)
    {
        weChatListeningMatchedMessageDAO.add(keywordsList,messageIdList);
    }

}
