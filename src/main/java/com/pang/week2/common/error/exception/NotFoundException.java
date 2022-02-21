package com.pang.week2.common.error.exception;

public class NotFoundException extends IllegalArgumentException{
    public NotFoundException(String msg) {
        super(msg);
    }
}
