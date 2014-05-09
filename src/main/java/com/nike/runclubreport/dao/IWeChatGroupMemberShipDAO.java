package com.nike.runclubreport.dao;

import com.nike.runclubreport.mapper.WeChatGroupMemberShipMapper;
import com.nike.runclubreport.persistence.WeChatGroupMemberShip;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlBatch;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/28/14.
 */
@UseStringTemplate3StatementLocator
@RegisterMapper(WeChatGroupMemberShipMapper.class)
public interface IWeChatGroupMemberShipDAO {
    @SqlQuery("select id, weChatGroupId, userName, saveTime from weChatGroupMemberShip ")
    List<WeChatGroupMemberShip> findAll();

    @SqlQuery("select userName from weChatGroupMemberShip " +
            "where weChatGroupId = :weChatGroupId")
    List<String> getUserNames(@Bind("weChatGroupId") String weChatGroupId);

    @SqlQuery("select userName from weChatGroupMemberShip a " +
            " where a.weChatGroupId = :weChatGroupId and " +
            " (select count(1) from weChatGroupMemberShip b " +
            " where a.userName = b.username) =1")
    List<String> getOldRelatedUserNames(@Bind("weChatGroupId") String weChatGroupId);

    @SqlUpdate("delete from weChatGroupMemberShip where weChatGroupId = :weChatGroupId")
    void delete(@Bind("weChatGroupId") String weChatGroupId);

    @SqlUpdate("delete from weChatGroupMemberShip where userName in (<userNameList>)")
    void deleteByUserNames(@BindIn("userNameList") List<String> userNameList);

    @SqlBatch("insert into weChatGroupMemberShip (weChatGroupId, userName)" +
            " values " +
            "(:weChatGroupId, :userName)")
    void addBatch(@Bind("weChatGroupId") Iterator<String> weChatGroupIdList,
                  @Bind("userName") Iterator<String> userNameList

    );
}
