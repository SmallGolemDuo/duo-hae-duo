package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.ConvertedRiotData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindGroupInfoResponse {

    private String groupName;
    private Set<ConvertedRiotData> findGroupMemberInfos;

}
