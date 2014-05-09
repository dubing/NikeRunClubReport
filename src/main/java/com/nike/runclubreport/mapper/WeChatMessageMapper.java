package com.nike.runclubreport.mapper;

import com.nike.runclubreport.enumtypes.MessageType;
import com.nike.runclubreport.persistence.WeChatMessage;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 4/23/14.
 */
public class WeChatMessageMapper implements ResultSetMapper<WeChatMessage> {
    @Override
    public WeChatMessage map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        WeChatMessage weChatMessage = new WeChatMessage(r.getInt("id"), r.getString("weChatGroupId"),
                r.getString("messageId"), r.getDate("sendTime"), r.getString("message"),
                MessageType.values()[r.getInt("messageType")], r.getString("userName"), r.getDate("saveTime")
        );
        return weChatMessage;
    }
}
