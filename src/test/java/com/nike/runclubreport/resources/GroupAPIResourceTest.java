package com.nike.runclubreport.resources;

import com.google.gson.Gson;
import com.nike.runclubreport.core.GroupMessages;
import com.nike.runclubreport.dao.IWeChatMessageDAO;
import com.nike.runclubreport.dao.WeChatGroupDAO;
import com.nike.runclubreport.dao.WeChatMemberDAO;
import com.nike.runclubreport.service.*;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by bing.du on 4/24/14.
 */
public class GroupAPIResourceTest {
    private HttpServletRequest request;
    private IWeChatMessageDAO weChatMessageDAO;
    private IWeChatMessageService weChatMessageService;
    private WeChatGroupDAO weChatGroupDAO;
    private IWeChatGroupService weChatGroupService;
    private GroupAPIResource groupAPIResource;
    private WeChatMemberDAO weChatMemberDAO;
    private IWeChatMemberService weChatMemberService;

    @Before
    public void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        //weChatMessageDAO = mock(IWeChatMessageDAO.class);

        weChatMessageService = new WeChatMessageService(weChatMessageDAO);
        weChatGroupService = new WeChatGroupService(weChatGroupDAO);
        weChatMemberService = new WeChatMemberService(weChatMemberDAO);
        //groupAPIResource = new GroupAPIResource(weChatGroupService,weChatMessageService,weChatMemberService);
    }

    @Test
    public void testJson() throws Exception {
        String messages = "﻿{\n" +
                "  \"conversations\": [\n" +
                "    {\n" +
                "      \"wechatgroupid\": \"1\",\n" +
                "      \"wechatgroupname\": \"test\",\n" +
                "      \"capturetime\": \"2012-11-1 11:00:00\",\n" +
                "      \"members\": [\n" +
                "        {\n" +
                "          \"username\": \"testuser1\",\n" +
                "          \"nickname\": \"haha1\",\n" +
                "          \"avator\": \"http://wx.qq.com/****\",\n" +
                "          \"gender\": 0,\n" +
                "          \"signature\": \"it's test user1\",\n" +
                "          \"location\": \"shanghai\",\n" +
                "          \"capturetime\": \"2012-11-1 11:00:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"username\": \"testuser2\",\n" +
                "          \"nickname\": \"haha2\",\n" +
                "          \"avator\": \"http://wx.qq.com/****\",\n" +
                "          \"gender\": \"1\",\n" +
                "          \"signature\": \"it's test user2\",\n" +
                "          \"location\": \"beijing\",\n" +
                "          \"capturetime\": \"2012-11-1 11:00:00\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"messages\": [\n" +
                "        {\n" +
                "          \"messageid\": \"2\",\n" +
                "          \"sendtime\": \"2012-11-1 11:00:00\",\n" +
                "          \"content\": \"ddd\",\n" +
                "          \"messagetype\": 1,\n" +
                "          \"senderusername\": \"xxx\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"messageid\": \"3\",\n" +
                "          \"sendtime\": \"2012-11-1 11:00:00\",\n" +
                "          \"content\": \"dfdf\",\n" +
                "          \"messagetype\": 2,\n" +
                "          \"senderusername\": \"xxx\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Gson gson = new Gson();
        GroupMessages groupMessages = gson.fromJson(messages, GroupMessages.class);

        assertThat(groupMessages.getConversations().size(), equalTo(1));
    }
}
