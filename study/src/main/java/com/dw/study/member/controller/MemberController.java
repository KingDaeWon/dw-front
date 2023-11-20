package com.dw.study.member.controller;


import com.dw.study.member.dto.LoginDto;
import com.dw.study.member.dto.MemberSignInResquestDto;
import com.dw.study.member.dto.MemberSignUpRequestDto;
import com.dw.study.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberSignInResquestDto request) throws Exception {
        return ResponseEntity.ok().body(memberService.signIn(request));
    }
    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public Long join(@Valid @RequestBody MemberSignUpRequestDto request) throws Exception {
        return memberService.signUp(request);
    }
}