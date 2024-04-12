package com.deux.duohaeduo.excpetion.group;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class GroupNotFoundException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "존재하지 않는 그룹입니다.";

    public GroupNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
