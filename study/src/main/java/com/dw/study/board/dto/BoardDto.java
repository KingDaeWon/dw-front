package com.dw.study.board.dto;

import com.dw.study.board.entity.Board;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardDto {

    private String memberId;
    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    public Board toBoard(Board board) {
        board.setMemberId(memberId);
        board.setTitle(title);
        board.setContent(content);
        return board;
    }

    public Board toBoard(){
        return Board.builder()
                .memberId(memberId)
                .title(title)
                .content(content)
                .build();
    }
}