package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.IWeChatMessageDAO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/21/14.
 */
public class WeChatMessageService implements IWeChatMessageService {
    private final IWeChatMessageDAO weChatMessageDAO;

    @Inject
    public WeChatMessageService(final IWeChatMessageDAO weChatMessageDAO) {
        this.weChatMessageDAO = weChatMessageDAO;
    }

    public void addListWeChatGroupMessage(Iterator<String> weChatGroupIdList,
                                   Iterator<String> messageIdList,
                                   List<Date> sendTimes,
                                   Iterator<String> message,
                                   List<Integer> messageTypes,
                                   Iterator<String> userNames)
    {
        weChatMessageDAO.addBatch(weChatGroupIdList,messageIdList,sendTimes,message,messageTypes,userNames);
    }
}
