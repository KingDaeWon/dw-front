package com.dw.study.board.service;

import com.dw.study.board.entity.Board;
import com.dw.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAllByOrderByIdDesc(pageable);
    }


    @Override
    public List<Board> findByExample(Board board) {
        // 대소문자 구분없이 title/memberId/content 각 컬럼에서 검색어를 모두 포함하는 ExampleMatcher
        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("memberId", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        // board 각 컬럼별 검색어가 담겨있는 Board 객체
        Example<Board> example = Example.of(board, customExampleMatcher);
        return boardRepository.findAll(example);
    }

    @Override
    public List<Board> findByContentLike(String content) {
        return boardRepository.findByContentLike("%" + content + "%");
    }

    @Override
    public List<Board> findByContentLikeAndMemberIdLike(String content, String memberId) {
        return boardRepository.findByContentLikeAndMemberIdLike("%" + content + "%", "%" + memberId + "%");
    }

    @Override
    public int getTotalCount() {
        return boardRepository.getTotalCount();
    }
}