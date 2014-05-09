package com.nike.runclubreport.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bing.du on 4/29/14.
 */
public class MemberShipBatchParams {
    private List<String> userNameList;
    private List<String> weChatGroupIdList;

    public MemberShipBatchParams() {
        userNameList = new ArrayList<>();
        weChatGroupIdList = new ArrayList<>();
    }

    public void addParam(String userName, String weChatGroupId) {
        userNameList.add(userName);
        weChatGroupIdList.add(weChatGroupId);
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public List<String> getWeChatGroupIdList() {
        return weChatGroupIdList;
    }
}
