package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FindAllGroupResponse {

    private Long id;
    private String groupName;

    public static FindAllGroupResponse from(Group group) {
        return FindAllGroupResponse.builder()
                .id(group.getId())
                .groupName(group.getGroupName())
                .build();
    }

}
