package com.deux.duohaeduo.dto.request;

import com.deux.duohaeduo.entity.Group;
import com.deux.duohaeduo.entity.GroupMember;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddGroupMemberRequest {

    @NotNull
    private Long groupId;
    @NotNull
    private String groupMember;

    public GroupMember toEntity(Group group) {
        return GroupMember.builder()
                .name(this.groupMember)
                .group(group)
                .build();
    }

}
