package com.nike.runclubreport.mapper;

import com.nike.runclubreport.persistence.WeChatGroupMemberShip;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 4/28/14.
 */
public class WeChatGroupMemberShipMapper implements ResultSetMapper<WeChatGroupMemberShip> {
    @Override
    public WeChatGroupMemberShip map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new WeChatGroupMemberShip(r.getInt("id"), r.getString("weChatGroupId"), r.getString("weChatGroupName"),
                r.getDate("saveTime"));
    }
}
