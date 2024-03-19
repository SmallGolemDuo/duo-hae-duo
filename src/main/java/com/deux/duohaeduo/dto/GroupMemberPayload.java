package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.entity.Group;
import com.deux.duohaeduo.entity.GroupMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class GroupMemberPayload {

    private Long id;
    private String gameName;

    public static GroupMemberPayload from(GroupMember gameMember) {
        return GroupMemberPayload.builder()
                .id(gameMember.getId())
                .gameName(gameMember.getName())
                .build();
    }

}
