package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.WeChatGroupDAO;
import com.nike.runclubreport.persistence.WeChatGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/24/14.
 */
public class WeChatGroupService implements IWeChatGroupService {
    private final WeChatGroupDAO weChatGroupDAO;

    @Inject
    public WeChatGroupService(final WeChatGroupDAO weChatGroupDAO) {
        this.weChatGroupDAO = weChatGroupDAO;
    }

    public WeChatGroup getGroupIdByWeChatGroupId(String weChatGroupId) {
        return weChatGroupDAO.findGroupIdByWeChatGroupId(weChatGroupId);
    }

    public int addGroup(String weChatGroupId, String weChatGroupName, Date captureTime) {
        return (int)weChatGroupDAO.addGroup(weChatGroupId,weChatGroupName,captureTime);
    }

    public void updateGroup(String weChatGroupId,String weChatGroupName,int size,String signature,Date captureTime)
    {
        weChatGroupDAO.updateGroup(weChatGroupId,weChatGroupName,size,signature,captureTime);
    }
}
