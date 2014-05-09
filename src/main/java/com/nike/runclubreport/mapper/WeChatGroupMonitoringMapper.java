package com.nike.runclubreport.mapper;

import com.nike.runclubreport.persistence.WeChatGroupMonitoring;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 4/30/14.
 */
public class WeChatGroupMonitoringMapper implements ResultSetMapper<WeChatGroupMonitoring> {
    @Override
    public WeChatGroupMonitoring map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new WeChatGroupMonitoring(r.getInt("id"), r.getString("weChatGroupId"),r.getInt("size"),
                r.getString("groupName"),r.getInt("maleAmount"),r.getInt("femaleAmount"),r.getDate("captureTime"),
                r.getDate("saveTime"));
    }
}
