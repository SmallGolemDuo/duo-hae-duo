package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.entity.Group;
import com.deux.duohaeduo.entity.GroupMember;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupMember {

    @NotNull
    private String gameName;

    public GroupMember toEntity(Group group) {
        return GroupMember.builder()
                .name(this.gameName)
                .group(group)
                .build();
    }

}
