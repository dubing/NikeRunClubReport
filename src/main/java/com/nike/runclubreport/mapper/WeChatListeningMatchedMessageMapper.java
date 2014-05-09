package com.nike.runclubreport.mapper;

import com.nike.runclubreport.persistence.WeChatListeningMatchedMessage;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 5/6/14.
 */
public class WeChatListeningMatchedMessageMapper implements ResultSetMapper<WeChatListeningMatchedMessage> {
    @Override
    public WeChatListeningMatchedMessage map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new WeChatListeningMatchedMessage(r.getInt("id"), r.getInt("keywordsId"),r.getString("messageId"),
                r.getDate("saveTime"));
    }
}
