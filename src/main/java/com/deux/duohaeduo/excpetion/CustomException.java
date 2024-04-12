package com.deux.duohaeduo.excpetion;

public abstract class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public abstract int getStatusCode();

}
