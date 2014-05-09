package com.nike.runclubreport.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bing.du on 4/25/14.
 */
public interface IWeChatMemberService {
    Integer getMemberIdByUserName(String userName);

    void addMembers(Iterator<String> userNameList,
                    Iterator<String> nickNameList,
                    Iterator<String> avatorList,
                    List<Integer> genderList,
                    Iterator<String> signatureList,
                    Iterator<String> locationList,
                    List<Date> captureTimeList);

    void deleteMembers(List<String> userNameList);

    void deleteOldGroupMembers(String weChatGroupId);
}
