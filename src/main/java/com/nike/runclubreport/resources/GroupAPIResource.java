package com.nike.runclubreport.resources;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.nike.runclubreport.core.Conversation;
import com.nike.runclubreport.core.MemberInfo;
import com.nike.runclubreport.core.MessageInfo;
import com.nike.runclubreport.core.GroupMessages;
import com.nike.runclubreport.persistence.Keyword;
import com.nike.runclubreport.persistence.WeChatGroup;
import com.nike.runclubreport.service.*;
import com.nike.runclubreport.util.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by andrew.bao on 4/22/14.
 */
@Path("/api/groups")
public class GroupAPIResource {
    private final IWeChatMessageService weChatMessageService;
    private final IWeChatGroupService weChatGroupService;
    private final IWeChatMemberService weChatMemberService;
    private final IWeChatGroupMemberShipService weChatGroupMemberShipService;
    private final IWeChatGroupMonitoringService weChatGroupMonitoringService;
    private final IWeChatListeningMatchedMessageService weChatListeningMatchedMessageService;
    private final IKeywordsService keywordsService;

    @Inject
    public GroupAPIResource(final IWeChatMessageService weChatMessageService,
                            final IWeChatGroupService weChatGroupService,
                            final IWeChatMemberService weChatMemberService,
                            final IWeChatGroupMemberShipService weChatGroupMemberShipService,
                            final IWeChatGroupMonitoringService weChatGroupMonitoringService,
                            final IWeChatListeningMatchedMessageService weChatListeningMatchedMessageService,
                            final IKeywordsService keywordsService) {
        this.weChatMessageService = weChatMessageService;
        this.weChatGroupService = weChatGroupService;
        this.weChatMemberService = weChatMemberService;
        this.weChatGroupMemberShipService = weChatGroupMemberShipService;
        this.weChatGroupMonitoringService = weChatGroupMonitoringService;
        this.weChatListeningMatchedMessageService = weChatListeningMatchedMessageService;
        this.keywordsService = keywordsService;
    }

    @POST
    @Path("/messages")
    public Response saveMessages(@FormParam("messages") String messages) throws ParseException {
        Gson gson = new Gson();
        GroupMessages groupMessages = gson.fromJson(messages, GroupMessages.class);
        if (groupMessages != null && !groupMessages.getConversations().isEmpty()) {
            for (Conversation conversation : groupMessages.getConversations()) {
                //the logic for WeChat group conversation
                WeChatGroup weChatGroup = checkWeChatGroup(conversation);
                //batch params for WeChat message,member,membership
                BatchParams batchParams = new BatchParams();
                //fill data for sql batch
                boolean needRefreshMember = fillBatchData(conversation, batchParams,
                        weChatGroup != null ? weChatGroup.getSignature() : "");
                if (needRefreshMember) {
                    storeWeChatMember(batchParams);
                    storeWeChatMemberShip(batchParams);
                }
                if (needRefreshMember || checkNeedRefreshGroup(weChatGroup, batchParams)) {
                    storeWeChatGroup(batchParams);
                }
                storeWeChatMessage(batchParams);
                storeWeChatGroupMonitoring(batchParams);
                storeWeChatListeningMatchedMessage(batchParams);
            }
        }
        return Response.ok().build();
    }

    private Boolean fillBatchData(Conversation conversation, BatchParams batchParams, String signature) throws ParseException {
        String weChatGroupId = conversation.getWeChatGroupId();
        batchParams.setWeChatGroupId(weChatGroupId);
        batchParams.setWeChatGroupName(conversation.getWeChatGroupName());
        batchParams.setSize(conversation.getMembers().size());
        batchParams.setCaptureTime(ParamFormat.ConvertStringToDate(conversation.getCaptureTime()));
        int maleAmount = 0;
        int femaleAmount = 0;
        List<String> signMemberList = new ArrayList<>();
        batchParams.setExitGroupMembers(weChatGroupMemberShipService.getUserNames(weChatGroupId));
        //fill batch data fro add WeChat member and delete old member
        for (MemberInfo weChatMember : conversation.getMembers()) {
            batchParams.getMemberBatchParams().addParam(weChatMember);
            if (weChatMember.getGender() == 0) {
                maleAmount++;
            } else if (weChatMember.getGender() == 1) {
                femaleAmount++;
            }
            if (batchParams.getExitGroupMembers().contains(weChatMember.getUserName())) {
                batchParams.getExitGroupMembers().remove(weChatMember.getUserName());
            } else {
                batchParams.getMemberShipBatchParams().addParam(weChatMember.getUserName(), weChatGroupId);
            }
            signMemberList.add(weChatMember.getUserName());
        }

        batchParams.setMaleAmount(maleAmount);
        batchParams.setFemaleAmount(femaleAmount);
        List<Keyword> keywords = keywordsService.findActiveKeyWords();
        for (MessageInfo weChatMessage : conversation.getMessages()) {
            String username = weChatMessage.getSenderUsername();
            if (username != null) {
                weChatMessage.setContent(new MinifyRuler().convert(weChatMessage.getContent()));
                batchParams.getMessageBatchParams().addParam(weChatGroupId, weChatMessage, username);
                for (Keyword keyword : keywords) {
                    if (weChatMessage.getContent().indexOf(keyword.getKeywords()) != -1) {
                        batchParams.getMatchMessageBatchParams().addParam(keyword.getId(), weChatMessage.getContent());
                    }
                }
            }
        }

        Collections.sort(signMemberList);
        Collections.reverse(signMemberList);
        String newSignString = String.valueOf(signMemberList.hashCode());
        batchParams.setNewSignature(newSignString);
        if (signature != null && signature.equals(newSignString)) {
            return false;
        }
        return true;
    }


    private WeChatGroup checkWeChatGroup(Conversation conversation) throws ParseException {
        //get GroupId ,if it doesn't exist, create a new WeChatGroup row
        return checkGroup(conversation.getWeChatGroupId(),
                conversation.getWeChatGroupName(),
                conversation.getCaptureTime());
    }

    private Boolean checkNeedRefreshGroup(WeChatGroup weChatGroup, BatchParams batchParams) {
        boolean needRefresh = true;
        if (weChatGroup.getWeChatGroupName().equals(batchParams.getWeChatGroupName())
                && weChatGroup.getSize() == batchParams.getSize()) {
            return false;
        }
        return needRefresh;
    }

    private void storeWeChatGroup(BatchParams batchParams) {
        updateWeChatGroup(batchParams.getWeChatGroupId(), batchParams.getWeChatGroupName(), batchParams.getSize(),
                batchParams.getNewSignature(), batchParams.getCaptureTime());
    }

    private void storeWeChatMember(BatchParams batchParams) {
        //delete old related members
        deleteOldGroupMembers(batchParams.getWeChatGroupId());
        //delete duplicate members
        deleteDuplicateMembers(batchParams.getMemberBatchParams().getUserNameList());
        //add new member
        addWeChatMember(batchParams.getMemberBatchParams());
    }

    private void storeWeChatMemberShip(BatchParams batchParams) {
        String weChatGroupId = batchParams.getWeChatGroupId();
        //delete old membership
        if (batchParams.getExitGroupMembers().size() != 0) {
            deleteOldMemberShip(batchParams.getExitGroupMembers());
        }
        //add new membership
        addNewMemberShips(batchParams.getMemberShipBatchParams());
    }

    private void storeWeChatMessage(BatchParams batchParams) {
        //add new message
        addWeChatMessage(batchParams.getMessageBatchParams());
    }

    private void storeWeChatGroupMonitoring(BatchParams batchParams) {
        addNewWeChatGroupMonitor(batchParams.getWeChatGroupId(), batchParams.getSize(), batchParams.getWeChatGroupName(),
                batchParams.getMaleAmount(), batchParams.getFemaleAmount(), batchParams.getCaptureTime());
    }

    private void storeWeChatListeningMatchedMessage(BatchParams batchParams) {
        addMatchedMessages(batchParams.getMatchMessageBatchParams());
    }

    private WeChatGroup checkGroup(String weChatGroupId, String weChatGroupName, String captureTime) throws ParseException {
        WeChatGroup weChatGroup = weChatGroupService.getGroupIdByWeChatGroupId(weChatGroupId);
        if (weChatGroup == null) {
            weChatGroupService.addGroup(weChatGroupId, weChatGroupName, ParamFormat.ConvertStringToDate(captureTime));
        }
        return weChatGroup;
    }

    private Integer checkMemberId(String userName) {
        Integer memberId = weChatMemberService.getMemberIdByUserName(userName);
        if (memberId != null) {
            return memberId;
        } else {
            return null;
        }
    }

    private void addWeChatMember(MemberBatchParams memberBatchParams) {
        weChatMemberService.addMembers(
                memberBatchParams.getUserNameList().iterator(),
                memberBatchParams.getNickNameList().iterator(),
                memberBatchParams.getAvatorList().iterator(),
                memberBatchParams.getGenderList(),
                memberBatchParams.getSignatureList().iterator(),
                memberBatchParams.getLocationList().iterator(),
                memberBatchParams.getCaptureTimeList()
        );
    }

    private void addWeChatMessage(MessageBatchParams messageBatchParams) {
        weChatMessageService.addListWeChatGroupMessage(
                messageBatchParams.getGroupIdList().iterator(),
                messageBatchParams.getMessageIdList().iterator(),
                messageBatchParams.getSendTimes(),
                messageBatchParams.getMessage().iterator(),
                messageBatchParams.getMessageTypes(),
                messageBatchParams.getUserNameList().iterator()
        );
    }

    private List<String> getOldRelatedUserNames(String weChatGroupId) {
        return weChatGroupMemberShipService.getOldRelatedUserNames(weChatGroupId);
    }

    private void deleteDuplicateMembers(List<String> userNameList) {
        weChatMemberService.deleteMembers(userNameList);
    }

    private void deleteOldGroupMembers(String weChatGroupId) {
        weChatMemberService.deleteOldGroupMembers(weChatGroupId);
    }

    private void deleteOldMemberShip(String weChatGroupId) {
        weChatGroupMemberShipService.deleteMemberShipByWeChatGroupId(weChatGroupId);
    }

    private void deleteOldMemberShip(List<String> exitGroupMembers) {
        weChatGroupMemberShipService.deleteMemberShipByUserNames(exitGroupMembers);
    }

    private void addNewMemberShips(MemberShipBatchParams memberShipBatchParams) {
        weChatGroupMemberShipService.addNewMemberShips(
                memberShipBatchParams.getWeChatGroupIdList().iterator(),
                memberShipBatchParams.getUserNameList().iterator()
        );
    }

    private void addNewWeChatGroupMonitor(String weChatGroupId, int size, String groupName,
                                          int maleAmount, int femaleAmount, Date captureTime) {
        weChatGroupMonitoringService.addGroupMonitoring(weChatGroupId, size, groupName, maleAmount, femaleAmount, captureTime);
    }

    private void addMatchedMessages(MatchMessageBatchParams matchMessageBatchParams) {
        weChatListeningMatchedMessageService.addMatchedMessages(matchMessageBatchParams.getKeywordsIdList(),
                matchMessageBatchParams.getMessageIdList().iterator());
    }

    private void updateWeChatGroup(String weChatGroupId, String weChatGroupName, int size, String signature, Date captureTime) {
        weChatGroupService.updateGroup(weChatGroupId, weChatGroupName, size, signature, captureTime);
    }
}
