package com.nike.runclubreport.mapper;

import com.nike.runclubreport.persistence.WeChatGroup;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 4/24/14.
 */
public class WeChatGroupMapper implements ResultSetMapper<WeChatGroup> {
    @Override
    public WeChatGroup map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new WeChatGroup(r.getInt("id"), r.getString("weChatGroupId"), r.getString("weChatGroupName"),
                r.getInt("size"),r.getString("signature"),r.getDate("captureTime"),r.getDate("saveTime"));
    }
}
