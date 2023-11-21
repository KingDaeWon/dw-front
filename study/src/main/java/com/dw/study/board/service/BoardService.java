package com.dw.study.board.service;

import com.dw.study.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface BoardService {
    List<Board> findAll();

    Board findById(Long boardId);

    Board save(Board board);

    void delete(Board board);

    Page<Board> findAll(Pageable pageable);

    int getTotalCount();

    List<Board> findByBoardContentLike(String boardContent);

    List<Board> findByBoardContentLikeAndMemberMemberNameLike(String boardContent, String memberName);

    List<Board> findByExample(Board board);
}
