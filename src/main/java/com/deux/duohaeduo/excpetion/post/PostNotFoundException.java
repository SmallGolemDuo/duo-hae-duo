package com.deux.duohaeduo.excpetion.post;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "존재하지 않는 게시물입니다.";

    public PostNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
