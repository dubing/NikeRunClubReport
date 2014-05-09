package com.nike.runclubreport.service;

import com.nike.runclubreport.persistence.WeChatGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/24/14.
 */
public interface IWeChatGroupService {
    WeChatGroup getGroupIdByWeChatGroupId(String weChatGroupId);

    int addGroup(String weChatGroupId, String weChatGroupName, Date captureTime);

    void updateGroup(String weChatGroupId,String weChatGroupName,int size,String signature,Date captureTime);
}
