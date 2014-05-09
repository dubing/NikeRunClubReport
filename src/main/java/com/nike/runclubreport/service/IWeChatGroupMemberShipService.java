package com.nike.runclubreport.service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/28/14.
 */
public interface IWeChatGroupMemberShipService {
    List<String> getOldRelatedUserNames(String weChatGroupId);

    void deleteMemberShipByWeChatGroupId(String weChatGroupId);

    void deleteMemberShipByUserNames(List<String> exitUserNames);

    void addNewMemberShips(Iterator<String> weChatGroupList,Iterator<String> userNameList);

    List<String> getUserNames(String weChatGroupId);
}
