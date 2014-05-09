package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.IWeChatGroupMonitoringDAO;

import java.util.Date;

/**
 * Created by bing.du on 4/30/14.
 */
public class WeChatGroupMonitoringService implements IWeChatGroupMonitoringService {
    private final IWeChatGroupMonitoringDAO weChatGroupMonitoringDAO;

    @Inject
    public WeChatGroupMonitoringService(final IWeChatGroupMonitoringDAO weChatGroupMonitoringDAO) {
        this.weChatGroupMonitoringDAO = weChatGroupMonitoringDAO;
    }

    public void addGroupMonitoring(String weChatGroupId,int size,String groupName,int maleAmount,
                            int femaleAmount,Date captureTime)
    {
        weChatGroupMonitoringDAO.add(weChatGroupId,size,groupName,maleAmount,femaleAmount,captureTime);
    }
}
