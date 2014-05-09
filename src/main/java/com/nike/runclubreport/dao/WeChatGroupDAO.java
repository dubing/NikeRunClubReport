package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.WeChatGroupMapper;
import com.nike.runclubreport.persistence.WeChatGroup;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.GetHandle;

import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/21/14.
 */
@RegisterMapper(WeChatGroupMapper.class)
public abstract class WeChatGroupDAO implements GetHandle {
    @SqlQuery("select count(1) from wechatgroup")
    public abstract int count();

    @SqlQuery("select id,weChatGroupId,weChatGroupName,size,signature,captureTime,saveTime" +
            " from wechatgroup where weChatGroupId= :weChatGroupId")
    public abstract WeChatGroup findGroupIdByWeChatGroupId(@Bind("weChatGroupId") String weChatGroupId);

    @SqlUpdate("insert into wechatgroup (weChatGroupId,weChatGroupName,size,captureTime,saveTime)" +
            " values " +
            "(:weChatGroupId,:weChatGroupName,0,:captureTime,:captureTime) " )
    @GetGeneratedKeys
    public abstract long addGroup(@Bind("weChatGroupId") String weChatGroupId,
                                  @Bind("weChatGroupName") String weChatGroupName,
                                  @Bind("captureTime") Date captureTime);

    @SqlUpdate("update wechatgroup set weChatGroupName = :weChatGroupName,size = :size," +
            "signature = :signature,captureTime = :captureTime " +
            "where weChatGroupId = :weChatGroupId" )
    public abstract void updateGroup(@Bind("weChatGroupId") String weChatGroupId,
                                     @Bind("weChatGroupName") String weChatGroupName,
                                     @Bind("size") int size,
                                     @Bind("signature") String signature,
                                     @Bind("captureTime") Date captureTime);
}
