package com.dw.study.member.dto;

import com.dw.study.member.entity.Member;
import com.dw.study.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

    @Data
    @Builder
    @AllArgsConstructor
    public class MemberSignUpRequestDto {

        @NotBlank(message = "아이디를 입력해주세요")
        private String email;

        @NotBlank(message = "닉네임을 입력해주세요.")
        @Size(min=2, message = "닉네임이 너무 짧습니다.")
        private String nickname;

        @NotNull(message = "나이를 입력해주세요")
        @Range(min = 0, max = 100)
        private int age;

        @NotBlank(message = "비밀번호를 입력해주세요")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
                message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
        private String password;

        @Builder
        public Member toEntity(){
            return Member.builder()
                    .email(email)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }
    }
