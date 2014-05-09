package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.IWeChatGroupMemberShipDAO;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/29/14.
 */
public class WeChatGroupMemberShipService implements IWeChatGroupMemberShipService {
    private final IWeChatGroupMemberShipDAO weChatGroupMemberShipDAO;

    @Inject
    public WeChatGroupMemberShipService(final IWeChatGroupMemberShipDAO weChatGroupMemberShipDAO) {
        this.weChatGroupMemberShipDAO = weChatGroupMemberShipDAO;
    }

    public List<String> getUserNames(String weChatGroupId) {
        return weChatGroupMemberShipDAO.getUserNames(weChatGroupId);
    }

    public List<String> getOldRelatedUserNames(String weChatGroupId) {
        return weChatGroupMemberShipDAO.getOldRelatedUserNames(weChatGroupId);
    }

    public void deleteMemberShipByWeChatGroupId(String weChatGroupId) {
        weChatGroupMemberShipDAO.delete(weChatGroupId);
    }

    public void deleteMemberShipByUserNames(List<String> exitUserNames) {
        weChatGroupMemberShipDAO.deleteByUserNames(exitUserNames);
    }

    public void addNewMemberShips(Iterator<String> weChatGroupList,Iterator<String> userNameList) {
        weChatGroupMemberShipDAO.addBatch(weChatGroupList,userNameList);
    }

}

