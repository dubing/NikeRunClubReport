package com.nike.runclubreport.util;

import com.nike.runclubreport.core.MemberInfo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bing.du on 4/25/14.
 */
public class MemberBatchParams {
    private List<String> userNameList;
    private List<String> nickNameList;
    private List<String> avatorList;
    private List<Integer> genderList;
    private List<String> signatureList;
    private List<String> locationList;
    private List<Date> captureTimeList;

    public MemberBatchParams()
    {
        userNameList = new ArrayList<>();
        nickNameList = new ArrayList<>();
        avatorList = new ArrayList<>();
        genderList = new ArrayList<>();
        signatureList = new ArrayList<>();
        locationList = new ArrayList<>();
        captureTimeList = new ArrayList<>();
    }

    public void addParam(MemberInfo weChatMember) throws ParseException {
        userNameList.add(weChatMember.getUserName());
        nickNameList.add(weChatMember.getNickName());
        avatorList.add(weChatMember.getAvaTor());
        genderList.add(weChatMember.getGender());
        signatureList.add(weChatMember.getSignature());
        locationList.add(weChatMember.getLocation());
        captureTimeList.add(ParamFormat.ConvertStringToDate(weChatMember.getCaptureTime()));
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public List<String> getNickNameList() {
        return nickNameList;
    }

    public List<String> getAvatorList() {
        return avatorList;
    }

    public List<Integer> getGenderList() {
        return genderList;
    }

    public List<String> getSignatureList() {
        return signatureList;
    }

    public List<String> getLocationList() {
        return locationList;
    }

    public List<Date> getCaptureTimeList() {
        return captureTimeList;
    }
}
