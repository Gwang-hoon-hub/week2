package com.pang.week2.service.validation;

public class MemberValidation {

    // 회원가입 시 필요한 조건 검사
    public boolean registerCheck(){
        // 닉네임 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)

        // `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패
        // 비밀번호 확인은 비밀번호와 정확하게 일치하기
        return true;
    }
}
