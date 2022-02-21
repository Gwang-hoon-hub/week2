package com.pang.week2.common.error.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    private String message;
    private String exceptionType; // 예외 타입
}
