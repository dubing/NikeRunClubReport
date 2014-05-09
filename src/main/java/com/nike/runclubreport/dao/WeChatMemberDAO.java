package com.nike.runclubreport.dao;

/**
 * Created by bing.du on 4/25/14.
 */

import com.nike.runclubreport.mapper.WeChatMemberMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.GetHandle;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@UseStringTemplate3StatementLocator
@RegisterMapper(WeChatMemberMapper.class)
public abstract class WeChatMemberDAO implements GetHandle {
    @SqlQuery("select count(1) from wechatmember")
    public abstract int count();

    @SqlQuery("select id from wechatmember where username= :userName")
    public abstract Integer findMemberIdByUserName(@Bind("userName") String userName);

    @SqlBatch("insert into wechatmember (username,nickName,avator,gender,signature,location,captureTime)" +
            " values " +
            "(:userName,:nickName,:avator,:gender,:signature,:location,:captureTime) ")
    public abstract void addBatch(@Bind("userName") Iterator<String> userNameList,
                                  @Bind("nickName") Iterator<String> nickNameList,
                                  @Bind("avator") Iterator<String> avatorList,
                                  @Bind("gender") List<Integer> genderList,
                                  @Bind("signature") Iterator<String> signatureList,
                                  @Bind("location") Iterator<String> locationList,
                                  @Bind("captureTime") List<Date> captureTimeList
    );

    @SqlUpdate("delete from wechatmember where userName in (<userNameList>)")
    public abstract void deleteMembers(@BindIn("userNameList") List<String> userNameList);

    @SqlUpdate("delete from wechatmember where userName in (" +
            "select userName from weChatGroupMemberShip as a " +
            "where a.weChatGroupId = :weChatGroupId and " +
            "(select count(1) from weChatGroupMemberShip as b " +
            "where a.userName = b.username) =1)")
    public abstract void deleteOldGroupMembers(@Bind("weChatGroupId") String weChatGroupId);
}
