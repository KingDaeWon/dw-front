package com.dw.study.member.dto;

import lombok.*;

/*
    Token정보를 Response할때 사용할 TokenDto
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;
}