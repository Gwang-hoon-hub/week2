package com.pang.week2.common.error.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotVaildResponse {
    private String field; // 에러가 난 필드
    private Object value; // 입력으로 들어온 값
    private String message; // 보낼 메세지
}
