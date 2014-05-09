package com.nike.runclubreport.service;

import java.util.Date;

/**
 * Created by bing.du on 4/30/14.
 */
public interface IWeChatGroupMonitoringService {
    void addGroupMonitoring(String weChatGroupId,int size,String groupName,int maleAmount,
                            int femaleAmount,Date captureTime);
}
