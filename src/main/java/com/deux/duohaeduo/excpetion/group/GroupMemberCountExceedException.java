package com.deux.duohaeduo.excpetion.group;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class GroupMemberCountExceedException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "그룹의 최대 인원 수는 5명입니다.";

    public GroupMemberCountExceedException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
