package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.FindGameMemberInfo;
import com.deux.duohaeduo.dto.request.FindGameUserInfoRequest;
import com.deux.duohaeduo.dto.response.FindGameMemberInfoResponse;
import com.deux.duohaeduo.service.webClient.RiotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class SingleService {

    private final RiotService riotService;
    private final GroupService groupService;

    // 개인 정보 조회
    @Transactional
    public FindGameMemberInfoResponse findGameUserInfo(FindGameUserInfoRequest findGameUserInfoRequest) throws IOException, JSONException {
        long matchCount = 20L;
        List<String> nicknameAndTag = List.of(findGameUserInfoRequest.getGameNickname().split("#"));
        System.out.println(nicknameAndTag.get(0));

        String tag;
        if (nicknameAndTag.size() != 1) {
            tag = nicknameAndTag.get(1);
        } else {
            tag = "KR1";
        }

        FindGameMemberInfo findGameMemberInfo = riotService.findRiotGameMemberInfo(nicknameAndTag.get(0), tag, 1L, matchCount);
        return new FindGameMemberInfoResponse(groupService.convertRiotSummonerInfo(findGameMemberInfo, nicknameAndTag.get(0), tag));
    }

}

