package com.dw.study.member.dto;

import com.dw.study.member.entity.Member;
import lombok.Builder;
import java.time.LocalDateTime;

public class MemberSignUpResponseDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private LocalDateTime enrollDate;

    @Builder
    public MemberSignUpResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.nickname = member.getNickname();
        this.enrollDate = member.getEnrollDate();
    }
}
