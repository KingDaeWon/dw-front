package com.dw.study.member.service;


import com.dw.study.member.dto.MemberSignInResquestDto;
import com.dw.study.member.dto.MemberSignUpRequestDto;

public interface MemberService {


    public String signIn(MemberSignInResquestDto requestDto) throws Exception;


    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;


}