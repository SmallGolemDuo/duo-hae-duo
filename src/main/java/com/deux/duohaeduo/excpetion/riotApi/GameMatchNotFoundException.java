package com.deux.duohaeduo.excpetion.riotApi;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class GameMatchNotFoundException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "매치 정보를 찾을 수 없습니다.";

    public GameMatchNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
