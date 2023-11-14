package com.dw.study.board.dto;

import com.dw.study.board.entity.Board;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardCreateDto {
    @NotBlank(message = "작성자는 필수입니다.")
    private String memberId;
    @NotBlank(message = "작성자는 필수입니다.")
    private String title;
    @NotBlank(message = "작성자는 필수입니다.")
    private String content;

    public Board toBoard() {
        return Board.builder()
                .title(title)
                .content(content)
                .memberId(memberId)
                .build();
    }
}
