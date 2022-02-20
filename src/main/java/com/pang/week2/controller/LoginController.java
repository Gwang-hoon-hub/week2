package com.pang.week2.controller;

import com.pang.week2.requestDto.reqRegisterDto;
import com.pang.week2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @PostMapping("/register")
    public String register(reqRegisterDto dto){
        memberService.save(dto);
        // 회원가입 성공을 하면 홈 화면으로 보여줘라
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(){
        return "/register";
    }


}
