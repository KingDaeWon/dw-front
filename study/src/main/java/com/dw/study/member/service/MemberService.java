package com.dw.study.member.service;

import com.dw.study.member.dto.MemberSignUpRequestDto;

public interface MemberService {
    // 회원가입
    public Long signUp(MemberSignUpRequestDto requestDto);
}
