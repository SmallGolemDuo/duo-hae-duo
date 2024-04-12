package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupResponse {

    private String groupName;

    public static CreateGroupResponse of(Group group) {
        return CreateGroupResponse.builder()
                .groupName(group.getGroupName())
                .build();
    }

}
