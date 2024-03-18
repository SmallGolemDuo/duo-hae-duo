package com.deux.duohaeduo.excpetion.riotApi;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "라이엇 계정을 찾을 수 없습니다.";

    public AccountNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
