package com.nike.runclubreport.mapper;

import com.nike.runclubreport.persistence.WeChatMember;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 4/25/14.
 */
public class WeChatMemberMapper implements ResultSetMapper<WeChatMember> {
    @Override
    public WeChatMember map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new WeChatMember(r.getInt("id"), r.getString("userName"),r.getString("nickName"),
                r.getString("avator"), r.getInt("gender"),r.getString("signature"),r.getString("location"),
                r.getDate("captureTime"),r.getDate("saveTime"));
    }
}
