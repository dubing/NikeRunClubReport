package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.WeChatGroupMonitoringMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

/**
 * Created by bing.du on 4/30/14.
 */
@RegisterMapper(WeChatGroupMonitoringMapper.class)
public interface IWeChatGroupMonitoringDAO {
    @SqlUpdate("insert into wechatgroupmonitoring (weChatGroupId,size,groupName,maleAmount,femaleAmount,captureTime) " +
            "values (:weChatGroupId, :size, :groupName,:maleAmount,:femaleAmount,:captureTime )")
    void add(@Bind("weChatGroupId") String weChatGroupId, @Bind("size") int size, @Bind("groupName") String groupName,
             @Bind("maleAmount") int maleAmount,@Bind("femaleAmount") int femaleAmount,
             @Bind("captureTime") Date captureTime);
}
