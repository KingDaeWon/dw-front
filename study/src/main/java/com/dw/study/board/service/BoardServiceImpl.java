package com.dw.study.board.service;

import com.dw.study.board.entity.Board;
import com.dw.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        return boardRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null); // null이면 null반환
    }

    @Override
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void delete(Board board) {
        boardRepository.delete(board);
    }
}