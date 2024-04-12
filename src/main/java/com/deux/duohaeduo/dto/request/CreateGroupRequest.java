package com.deux.duohaeduo.dto.request;

import com.deux.duohaeduo.dto.CreateGroupMember;
import com.deux.duohaeduo.entity.Group;
import com.deux.duohaeduo.entity.GroupMember;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupRequest {

    @NotNull
    private String groupName;

    @NotNull()
    @Size(min = 1, max = 5, message = "1개 그룹의 멤버는 최소 1명이상, 최대 5명까지 입니다.")
    private Set<CreateGroupMember> groupMembers;

    public Group toEntity() {
        Group group = Group.builder()
                .groupName(this.groupName)
                .groupMembers(new HashSet<>())
                .build();
        Set<GroupMember> members = groupMembers.stream()
                .map(createGroupMember -> createGroupMember.toEntity(group))
                .collect(Collectors.toSet());
        group.addGroupMembers(members);
        return group;
    }

}
