package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.KeywordMapper;
import com.nike.runclubreport.persistence.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by andrew.bao on 4/30/14.
 */
@RegisterMapper(KeywordMapper.class)
public interface IUserDAO {
    @SqlQuery("select id, username, displayname, password, type, saveTime from user where username = :userName")
    User getUserByName(@Bind("userName") String userName);

    @SqlQuery("select id, username, displayname, password, type, saveTime from user where username = :userName and password = :password")
    User validateUser(@Bind("userName") String userName, @Bind("password") String password);
}