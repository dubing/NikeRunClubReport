package com.nike.runclubreport.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bing.du on 5/6/14.
 */
public class MatchMessageBatchParams {
    private List<Integer> keywordsIdList;
    private List<String> messageIdList;

    public MatchMessageBatchParams()
    {
        keywordsIdList  = new ArrayList<>();
        messageIdList = new ArrayList<>();
    }

    public void addParam(int keywordsId,String messageId)
    {
        keywordsIdList.add(keywordsId);
        messageIdList.add(messageId);
    }

    public List<Integer> getKeywordsIdList() {
        return keywordsIdList;
    }

    public List<String> getMessageIdList() {
        return messageIdList;
    }
}
