package com.pang.week2.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Builder
public class reqRegisterDto {

    @NotNull
    @Pattern(regexp = "[0-9a-zA-Z]")
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    @NotNull
    private String name;

}
