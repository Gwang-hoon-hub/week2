package com.pang.week2.security;

import com.pang.week2.Model.Member;
import com.pang.week2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

//    public UserDetailsServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Member member = Optional
                 .ofNullable(memberRepository.findByUsername(username))
                 .orElseThrow(() -> new UsernameNotFoundException("user can't find"));
        // .orElseThrow 예외처리를 던져야 되는데 왜 안되냐..?
        return new UserDetailsImpl(member);
    }
}
