package com.pang.week2.controller;

import com.pang.week2.Model.Member;
import com.pang.week2.dtoClass.MemberDto;
import com.pang.week2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입에 대한 모든 데이터를 적고 회원가입 요청을 보내면 회원가입.
    @PostMapping("/signup")
    public ResponseEntity register(@Valid MemberDto.reqRegisterDto dto) {
        memberService.save(dto);
        // 회원가입 성공을 하면 홈 화면으로 보여줘라
        return "redirect:/";
    }

    @PostMapping("/signin")
    public  ResponseEntity login(@RequestBody MemberDto.reqLoginDto dto){

    }

    @GetMapping("/logout")
    public ResponseEntity logout(){

    }


}
