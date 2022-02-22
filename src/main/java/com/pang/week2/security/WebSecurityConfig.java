package com.pang.week2.security;

import com.pang.week2.common.error.AuthFailureHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    public void configure(WebSecurity web) {
        // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf() .ignoringAntMatchers("/**");

        http
                .authorizeRequests()
                    .antMatchers("/register", "/","/css/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
//                    .loginPage("/login")
                //  로그인 처리 : POST방식 (/signin)
                    .loginProcessingUrl("/signin")
                    .successForwardUrl("/")
//                    .successHandler(new LoginSucessHandler())
                    .defaultSuccessUrl("/")
                    .failureHandler(new AuthFailureHandler())
                    .permitAll()
                // defaultSuccessUrl -> 성공 시 가야하는 url / failureUrl -> 실패 시 가야하는 url
//                  .defaultSuccessUrl('/')
//                  .failureUrl()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
}
