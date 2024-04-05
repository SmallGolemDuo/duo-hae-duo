package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.*;
import com.deux.duohaeduo.dto.riot.matchInfo.Participant;
import com.deux.duohaeduo.dto.riot.matchInfo.SummonerMatchInfo;
import com.deux.duohaeduo.dto.request.AddGroupMemberRequest;
import com.deux.duohaeduo.dto.request.CreateGroupRequest;
import com.deux.duohaeduo.dto.request.DeleteGroupMemberRequest;
import com.deux.duohaeduo.dto.request.DeleteGroupRequest;
import com.deux.duohaeduo.dto.response.CreateGroupResponse;
import com.deux.duohaeduo.dto.response.FindAllGroupResponse;
import com.deux.duohaeduo.dto.response.FindByIdGroupResponse;
import com.deux.duohaeduo.dto.response.FindGroupInfoResponse;
import com.deux.duohaeduo.entity.Group;
import com.deux.duohaeduo.entity.GroupMember;
import com.deux.duohaeduo.enums.GameModes;
import com.deux.duohaeduo.enums.SummonerSpells;
import com.deux.duohaeduo.excpetion.group.GroupMemberCountExceedException;
import com.deux.duohaeduo.excpetion.group.GroupMemberNotFoundException;
import com.deux.duohaeduo.excpetion.group.GroupNotFoundException;
import com.deux.duohaeduo.repository.GroupRepository;
import com.deux.duohaeduo.service.webClient.RiotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    private final RiotService riotService;

    // 그룹안에 유저 전체 정보 조회
    @Transactional
    public FindGroupInfoResponse findGroupInfo(Long groupId) throws IOException, JSONException {
        Group group = groupRepository.findById(groupId).orElseThrow(GroupNotFoundException::new);
        long matchCount = 5L;
        Set<ConvertedRiotData> convertedRiotDatas = new HashSet<>();
        long gameMemberCount = 1L;
        for (GroupMember groupMember : group.getGroupMembers()) {

            // 닉네임 태그 분리
            List<String> nicknameAndTag = List.of(groupMember.getName().split("#"));

            String nickname = nicknameAndTag.get(0);
            String tag; // 태그 입력 안할 시 기본 태그 주입
            if (nicknameAndTag.size() != 1) {
                tag = nicknameAndTag.get(1);
            } else {
                tag = "KR1";
            }

            FindGameMemberInfo findGameMemberInfo = riotService.findRiotGameMemberInfo(nickname, tag, gameMemberCount, matchCount);
            gameMemberCount++;
            convertedRiotDatas.add(convertRiotSummonerInfo(findGameMemberInfo, nickname, tag));
        }

        return new FindGroupInfoResponse(group.getGroupName(), convertedRiotDatas);
    }

    // 그룹 만들기 + 게임유저 추가
    @Transactional
    public CreateGroupResponse createGroup(CreateGroupRequest createGroupRequest) {
        return CreateGroupResponse.of(groupRepository.save(createGroupRequest.toEntity()));
    }

    // 그룹 전체 조회
    @Transactional
    public List<FindAllGroupResponse> findAllGroup() {
        return groupRepository.findAll().stream()
                .map(FindAllGroupResponse::from)
                .collect(Collectors.toList());
    }

    // 그룹 상세 조회
    @Transactional
    public FindByIdGroupResponse findById(Long groupId) {
        return FindByIdGroupResponse.from(groupRepository.findById(groupId).orElseThrow(GroupNotFoundException::new));
    }

    // 그룹 삭제
    @Transactional
    public boolean deleteGroup(DeleteGroupRequest deleteGroupRequest) {
        Group group = groupRepository.findById(deleteGroupRequest.getGroupId()).orElseThrow(GroupNotFoundException::new);
        groupRepository.delete(group);
        return true;
    }

    // 이미 존재하는 그룹에 유저 추가
    @Transactional
    public boolean addGroupGameMember(AddGroupMemberRequest addGroupGameMemberRequest) {
        Group group = groupRepository.findById(addGroupGameMemberRequest.getGroupId()).orElseThrow(GroupNotFoundException::new);

        if (group.getGroupMembers().size() >= 5) {
            throw new GroupMemberCountExceedException();
        }

        GroupMember groupMember = addGroupGameMemberRequest.toEntity(group);

        Set<GroupMember> groupMembers = group.getGroupMembers();
        groupMembers.add(groupMember);
        group.addGroupMembers(groupMembers);

        groupRepository.save(group);

        return true;
    }

    // 그룹안에 게임유저 삭제
    @Transactional
    public boolean deleteGroupGameMember(DeleteGroupMemberRequest deleteGroupMemberRequest) {
        Group group = groupRepository.findById(deleteGroupMemberRequest.getGroupId()).orElseThrow(GroupNotFoundException::new);

        if (!group.containsGroupMemberId(deleteGroupMemberRequest.getGroupMemberId())) {
            throw new GroupMemberNotFoundException();
        }

        group.deleteGroupMember(deleteGroupMemberRequest.getGroupMemberId());
        groupRepository.save(group);
        return true;
    }


    @Transactional
    public ConvertedRiotData convertRiotSummonerInfo(FindGameMemberInfo findGameMemberInfo, String nickname, String tag) throws JSONException {
        JSONObject jsonUserInfo = new JSONObject(findGameMemberInfo.getUserInfo());

        SearchSummonerInfo searchSummonerInfo = null;

        String summonerLevel = jsonUserInfo.getString("summonerLevel"); // 검색 된 소환사레벨
        String profileIconId = jsonUserInfo.getString("profileIconId"); // 검색 된 소환사 프로필 id

        List<MatchInfo> matchInfos = new ArrayList<>();

        // 매치 데이터
        for (SummonerMatchInfo summonerMatchInfo : findGameMemberInfo.getMatchInfoList()) { // 1게임
            List<MatchParticipantInfo> matchParticipantInfos = new ArrayList<>();

            Date date = new Date(summonerMatchInfo.getInfo().getGameCreation()); // 게임 만든 날짜
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
            String gameCreatedDate = simpleDateFormat.format(date);

            // 추가 코드 이넘도 추가
            String gameMode = GameModes.findById(summonerMatchInfo.getInfo().getQueueID()); // 게임 모드

            String gameTotalTime = String.valueOf(Math.floor(summonerMatchInfo.getInfo().getGameDuration() / 60f)); // 게임 진행 시간

            for (Participant participant : summonerMatchInfo.getInfo().getParticipants()) { // 10명

                String championName = findFiddlesticks(participant.getChampionName()); // 챔피언 이름
                String participantName = participant.getRiotIDGameName(); // 소환사명
                boolean isWin = participant.getWin(); // 팀을 나누기 위한 승패여부

                if (nickname.equals(participant.getRiotIDGameName()) && tag.equals(participant.getRiotIDTagline())) { // 검색 된 소환사 기준 찾기

                    String searchChampionName = findFiddlesticks(participant.getChampionName());

                    List<Long> items = List.of( // 아이템 아이템이 0이면 없는 것
                            participant.getItem0(),
                            participant.getItem1(),
                            participant.getItem2(),
                            participant.getItem3(),
                            participant.getItem4(),
                            participant.getItem5(),
                            participant.getItem6()
                    );

                    Long kills = participant.getKills(); // 킬
                    Long deaths = participant.getDeaths(); // 데스
                    Long assists = participant.getAssists(); // 어시

                    String spell1 = SummonerSpells.findByKey(participant.getSummoner1ID()); // 스펠1
                    String spell2 = SummonerSpells.findByKey(participant.getSummoner2ID()); // 스펠2

                    boolean searchSummonerIsWin = participant.getWin(); // 검색 된 소환사 승패 여부 // 이겼으면 파란색, 졌으면 빨간색

                    searchSummonerInfo = SearchSummonerInfo.builder()
                            .championName(searchChampionName)
                            .items(items)
                            .kills(kills)
                            .deaths(deaths)
                            .assists(assists)
                            .spell1(spell1)
                            .spell2(spell2)
                            .win(searchSummonerIsWin)
                            .build();
                }
                matchParticipantInfos.add(MatchParticipantInfo.builder()
                        .participantName(participantName)
                        .championName(championName)
                        .win(isWin)
                        .build());

            }
            matchInfos.add(MatchInfo.builder()
                    .gameCreatedDate(gameCreatedDate)
                    .gameMode(gameMode)
                    .gameTotalTime(gameTotalTime)
                    .matchParticipantInfos(matchParticipantInfos)
                    .searchSummonerInfo(searchSummonerInfo)
                    .build());

        }
        return ConvertedRiotData.builder()
                .summonerName(nickname)
                .summonerLevel(summonerLevel)
                .profileIconId(profileIconId)
                .matchInfos(matchInfos)
                .build();
    }

    // 라이엇 제공 피들스틱 네임 오류 수정
    private String findFiddlesticks(String championName) {
        if (championName.equals("FiddleSticks")) {
            return "Fiddlesticks";
        }
        return championName;
    }

}
