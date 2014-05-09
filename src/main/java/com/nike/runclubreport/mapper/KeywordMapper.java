package com.nike.runclubreport.mapper;

import com.nike.runclubreport.persistence.Keyword;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bing.du on 4/22/14.
 */
public class KeywordMapper implements ResultSetMapper<Keyword> {
    @Override
    public Keyword map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new Keyword(r.getInt("id"), r.getString("keywords"), r.getDate("startTime"), r.getDate("endTime"),
                r.getDate("saveTime"));
    }
}
