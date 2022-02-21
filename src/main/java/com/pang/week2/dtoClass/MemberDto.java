package com.pang.week2.dtoClass;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class reqLoginDto{
        private String username;
        private String password;
        private String name;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class reqRegisterDto{
        @NotEmpty
        @Pattern(regexp = "[0-9a-zA-Z]")
        private String username;

        @NotEmpty
        @Size(min = 4)
        private String password;

        @NotEmpty
        private String name;
    }


}
