package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.WeChatMessageMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlBatch;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/23/14.
 */
@RegisterMapper(WeChatMessageMapper.class)
public interface IWeChatMessageDAO {
    @SqlBatch("insert into wechatmessage (weChatGroupId, messageId,sendTime,message,messageType,userName)" +
            " values " +
            "(:weChatGroupId, :messageId ,:sendTime,:message,:messageType,:userName)")
    void addBatch(@Bind("weChatGroupId") Iterator<String> weChatGroupIdList,
                  @Bind("messageId") Iterator<String> messageIdList,
                  @Bind("sendTime") List<Date> sendTimes,
                  @Bind("message") Iterator<String> message,
                  @Bind("messageType") List<Integer> messageTypes,
                  @Bind("userName") Iterator<String> userNames
    );
}
