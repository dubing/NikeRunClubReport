package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.KeywordMapper;
import com.nike.runclubreport.persistence.Keyword;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/22/14.
 */
@RegisterMapper(KeywordMapper.class)
public interface IKeywordDAO {
    @SqlQuery("select id, keywords, startTime, endTime, saveTime from wechatlisteningkeywords ")
    List<Keyword> findAll();

    @SqlQuery("select id, keywords, startTime, endTime, saveTime from wechatlisteningkeywords " +
            "where startTime <= now() and endTime>= now()")
    List<Keyword> findActiveKeyWords();

    @SqlUpdate("insert into wechatlisteningkeywords (keywords, startTime, endTime) " +
            "values (:keywords, :startTime, :endTime )")
    void add(@Bind("keywords") String keywords, @Bind("startTime") Date startTime, @Bind("endTime") Date endTime);

    @SqlUpdate("update wechatlisteningkeywords set keywords= :keywords ,startTime = :startTime ," +
            "endTime = :endTime where id = :id")
    void update(@Bind("id") int id, @Bind("keywords") String keywords, @Bind("startTime") Date startTime,
                @Bind("endTime") Date endTime);

}
