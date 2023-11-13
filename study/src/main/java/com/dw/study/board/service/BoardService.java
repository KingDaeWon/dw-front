package com.dw.study.board.service;

import com.dw.study.board.entity.Board;

import java.util.List;
public interface BoardService {
    List<Board> findAll();

    Board findById(Long id);

    Board save(Board board);

    void deleteById(Long id);

}
