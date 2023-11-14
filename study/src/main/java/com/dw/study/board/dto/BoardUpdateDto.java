package com.dw.study.board.dto;

import com.dw.study.board.entity.Board;

import javax.validation.constraints.NotBlank;

public class BoardUpdateDto {
    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    @NotBlank(message = "제목은 필수입니다.")
    private String content;

    public Board toBoard(Board board){
        board.setTitle(title);
        board.setContent(content);
        return board;
    }

}
