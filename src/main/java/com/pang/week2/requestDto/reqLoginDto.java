package com.pang.week2.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class reqLoginDto {
    private String username;
    private String password;
    private String name;
}
