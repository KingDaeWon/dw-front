package com.dw.study.board.dto;

import com.dw.study.board.entity.Board;
import com.dw.study.member.entity.Member;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardSearchDto {
    private String boardTitle;
    private Member member;
    private String boardContent;
    private LocalDateTime boardCreatedAt;



    public Board toBoard() {
        return Board.builder()
                .boardTitle(boardTitle)
                .member(member)
                .boardContent(boardContent)
                .boardCreatedAt(boardCreatedAt)
                .build();
    }

}
