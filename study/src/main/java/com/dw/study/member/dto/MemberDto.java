package com.dw.study.member.dto;

import com.dw.study.member.entity.Member;
import com.dw.study.member.entity.Role;

import java.time.LocalDateTime;

public class MemberDto {

    private String email;

    private String password;

    private String nickname;

    private LocalDateTime enrollDate;
    private Role role;

    public Member toMember() {
        Member member = Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .enrollDate(enrollDate)
                .role(role.USER)
                .build();
        return member;
    }
}
