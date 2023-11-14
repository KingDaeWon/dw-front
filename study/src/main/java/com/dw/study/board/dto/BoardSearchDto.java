package com.dw.study.board.dto;
import com.dw.study.board.entity.Board;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class BoardSearchDto {
    private String title;
    private String memberId;
    private String content;

    public void setTitle(String title) {
        this.title = trimValueOrNull(title);
    }
    public void setMemberId(String memberId) {
        this.memberId = trimValueOrNull(memberId);
    }
    public void setContent(String content) {
        this.content = trimValueOrNull(content);
    }
    public String trimValueOrNull(@Nullable String v) {
        if(v == null)
            return null;
        v = v.trim();
        return !"".equals(v) ? v : null;
    }

    public Board toBoard() {
        return Board.builder()
                .title(title)
                .memberId(memberId)
                .content(content)
                .build();
    }

}
