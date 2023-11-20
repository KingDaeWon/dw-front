package com.dw.study.board.entity;

import com.dw.study.comment.entity.Comment;
import com.dw.study.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@SequenceGenerator(name = "SEQ_BOARD_ID", sequenceName = "SEQ_BOARD_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD_ID")
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, length = 4000)
    private String content;

    // ManyToOne : 여러개의 댓글, 한개의 아이디
    // cascade = CascadeType.PERSIST : 삭제됐을 때 데이터 관리 어떻게할거야? 유지할거야
    @JsonIgnoreProperties("board")  // Ignore the 'board' property in the Member entity to avoid recursion in JSON serialization
    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
    private List<Comment> comment;

    @Column(columnDefinition = "date default sysdate")
    @CreationTimestamp
    private LocalDateTime createdAt;
}