package com.deux.duohaeduo.excpetion.group;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class GroupMemberNotFoundException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "그룹의 존재하지 않는 멤버입니다.";

    public GroupMemberNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
