package com.pang.week2.service;

import com.pang.week2.Model.Member;
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


    public void save(MemberDto.reqRegisterDto dto){

        if(dto.getPassword().contains(dto.getUsername())){
            throw new IllegalArgumentException();
        }
        // 복화화된 암호
        String pwd = passwordEncoder.encode(dto.getPassword());
        Member member = Member.builder()
                .username(dto.getUsername())
                .password(pwd)
                .name(dto.getName())
                .build();
        System.out.println(member + "맴버가 잘 들어갔나?");
        memberRepository.save(member);
    }
}
