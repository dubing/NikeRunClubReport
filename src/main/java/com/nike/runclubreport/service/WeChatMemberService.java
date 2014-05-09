package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.WeChatMemberDAO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/25/14.
 */
public class WeChatMemberService implements IWeChatMemberService {
    private final WeChatMemberDAO weChatMemberDAO;

    @Inject
    public WeChatMemberService(final WeChatMemberDAO weChatMemberDAO) {
        this.weChatMemberDAO = weChatMemberDAO;
    }

    public Integer getMemberIdByUserName(String userName)
    {
        return weChatMemberDAO.findMemberIdByUserName(userName);
    }

    public void addMembers(Iterator<String> userNameList,
                    Iterator<String> nickNameList,
                    Iterator<String> avatorList,
                    List<Integer> genderList,
                    Iterator<String> signatureList,
                    Iterator<String> locationList,
                    List<Date> captureTimeList)
    {
        weChatMemberDAO.addBatch(userNameList,nickNameList,avatorList,genderList,signatureList,locationList,captureTimeList);
    }

    public void deleteMembers(List<String> userNameList)
    {
        weChatMemberDAO.deleteMembers(userNameList);
    }

    public void deleteOldGroupMembers(String weChatGroupId)
    {
        weChatMemberDAO.deleteOldGroupMembers(weChatGroupId);
    }
}
