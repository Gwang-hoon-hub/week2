package com.pang.week2.controller;

import com.pang.week2.Model.Member;
import com.pang.week2.dtoClass.MemberDto;
import com.pang.week2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity register(@RequestBody @Valid MemberDto.reqRegisterDto dto) {
        memberService.save(dto);
        return ResponseEntity.ok().build();
    }

//    // 로그인
//    @PostMapping("/signin")
//    public  ResponseEntity login(@RequestBody MemberDto.reqLoginDto dto){
//
//    }

//    // 로그아웃
//    @GetMapping("/logout")
//    public ResponseEntity logout(){
//
//    }


}


