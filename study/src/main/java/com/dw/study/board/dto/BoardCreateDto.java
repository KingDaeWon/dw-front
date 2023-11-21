package com.dw.study.board.dto;

import com.dw.study.board.entity.Board;
import com.dw.study.member.entity.Member;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class BoardCreateDto {

    private Member member;

    @NotBlank(message = "제목은 필수입니다.")
    private String boardTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String boardContent;


    public Board toBoard() {
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .member(member)
                .build();
    }

}
