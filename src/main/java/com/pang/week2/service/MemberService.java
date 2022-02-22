package com.pang.week2.service;

import com.pang.week2.Model.Member;
import com.pang.week2.common.error.exception.NotFoundException;
import com.pang.week2.dtoClass.MemberDto;
import com.pang.week2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    public void save(MemberDto.reqRegisterDto dto){
        if (memberRepository.existsByUsername(dto.getUsername())){
            throw new NotFoundException("이미 사용중인 아이디 입니다.");
        }
        // 비밀번호에 닉네임이 포함되어 있는 경우
        if(dto.getPassword().contains(dto.getUsername())){
            throw new NotFoundException("비밀번호가 양식에 맞지 않습니다.");
        }
        if (!dto.getPassword().equals(dto.getPasswordCheck())){
            throw new NotFoundException("비밀번호가 일치 하지 않습니다.");
        }
        // 복화화된 암호
        String pwd = passwordEncoder.encode(dto.getPassword());
        Member member = Member.builder()
                .username(dto.getUsername())
                .password(pwd)
                .name(dto.getName())
                .build();
        memberRepository.save(member);
    }
}
