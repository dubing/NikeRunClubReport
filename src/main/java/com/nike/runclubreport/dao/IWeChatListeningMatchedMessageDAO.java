package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.WeChatListeningMatchedMessageMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlBatch;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 5/6/14.
 */
@RegisterMapper(WeChatListeningMatchedMessageMapper.class)
public interface IWeChatListeningMatchedMessageDAO {
    @SqlBatch("insert into wechatlisteningmatchedmessage (keywordsId,messageId) " +
            "values (:keywordsId, :messageId)")
    void add(@Bind("keywordsId") List<Integer> keywordsIdList,
             @Bind("messageId") Iterator<String> messageIdList
             );
}
