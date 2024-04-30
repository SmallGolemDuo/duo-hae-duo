package com.deux.duohaeduo.excpetion.post;

import com.deux.duohaeduo.excpetion.CustomException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundException extends CustomException {

    public static final String EXCEPTION_MESSAGE = "존재하지 않는 댓글입니다.";

    public CommentNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }

}
