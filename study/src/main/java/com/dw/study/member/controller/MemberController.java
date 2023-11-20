package com.dw.study.member.controller;


import com.dw.study.member.dto.MemberSignUpRequestDto;
import com.dw.study.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signUp")
    public Long signUp(@RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.signUp(requestDto);
    }
}