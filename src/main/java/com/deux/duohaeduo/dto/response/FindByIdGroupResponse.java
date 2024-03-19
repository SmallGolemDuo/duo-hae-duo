package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.GroupMemberPayload;
import com.deux.duohaeduo.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FindByIdGroupResponse {

    private Long groupId;
    private String groupName;
    private Set<GroupMemberPayload> groupMemberPayloads;

    public static FindByIdGroupResponse from(Group group) {
        return FindByIdGroupResponse.builder()
                .groupId(group.getId())
                .groupName(group.getGroupName())
                .groupMemberPayloads(group.getGroupMembers().stream()
                        .map(GroupMemberPayload::from)
                        .collect(Collectors.toSet()))
                .build();
    }
}
