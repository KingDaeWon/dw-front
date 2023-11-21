package com.dw.study.board.dto;

import com.dw.study.board.entity.Board;
import com.dw.study.member.entity.Member;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardUpdateDto {
    private Member member;

    @NotBlank(message = "제목은 필수입니다.")
    private String boardTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String boardContent;


    public Board toBoard(Board board) {
        board.setBoardTitle(boardTitle);
        board.setBoardContent(boardContent);
        board.setMember(member);
        return board;
    }

}
