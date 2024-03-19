package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.request.AddGroupMemberRequest;
import com.deux.duohaeduo.dto.request.CreateGroupRequest;
import com.deux.duohaeduo.dto.request.DeleteGroupMemberRequest;
import com.deux.duohaeduo.dto.request.DeleteGroupRequest;
import com.deux.duohaeduo.dto.response.CreateGroupResponse;
import com.deux.duohaeduo.dto.response.FindAllGroupResponse;
import com.deux.duohaeduo.dto.response.FindByIdGroupResponse;
import com.deux.duohaeduo.dto.response.FindGroupInfoResponse;
import com.deux.duohaeduo.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lol/groups")
public class GroupController {

    private final GroupService groupService;

    // 그룹 멤버 전체 정보 조회
    @GetMapping("/group-infos/{groupId}")
    public FindGroupInfoResponse findGroupInfo(@PathVariable(name = "groupId") Long groupId) throws IOException, JSONException {

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        //실험할 코드 추가
        FindGroupInfoResponse findGroupInfoResponse = groupService.findGroupInfo(groupId);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        double secDiffTime = (double) (afterTime - beforeTime) / 1000.0; //두 시간에 차 계산
        System.out.println("시간차이(m) : " + secDiffTime);

        return findGroupInfoResponse;
    }

    // 그룹 만들기
    @PostMapping()
    public CreateGroupResponse create(@Valid @RequestBody CreateGroupRequest createGroupRequest) {
        return groupService.createGroup(createGroupRequest);
    }

    // 그룹 전체 조회
    @GetMapping()
    public List<FindAllGroupResponse> findAllGroup() {
        return groupService.findAllGroup();
    }

    // 그룹 상세 조회
    @GetMapping("/{groupId}")
    public FindByIdGroupResponse findGroup(@PathVariable(name = "groupId") Long groupId) {
        return groupService.findById(groupId);
    }

    // 그룹 삭제
    @DeleteMapping()
    public boolean deleteGroup(@Valid @RequestBody DeleteGroupRequest deleteRequest) {
        return groupService.deleteGroup(deleteRequest);
    }

    // 그룹 멤버 추가
    @PostMapping("/group-members")
    public boolean addGroupGameMember(@Valid @RequestBody AddGroupMemberRequest addGroupGameMemberRequest) {
        return groupService.addGroupGameMember(addGroupGameMemberRequest);
    }

    // 그룹 멤버 삭제
    @DeleteMapping("/group-members")
    public boolean deleteGroupGameMember(@Valid @RequestBody DeleteGroupMemberRequest deleteGroupMemberRequest) {
        return groupService.deleteGroupGameMember(deleteGroupMemberRequest);
    }

}
