package com.dw.study.board.controller;

import com.dw.study.board.dto.BoardCreateDto;
import com.dw.study.board.dto.BoardUpdateDto;
import com.dw.study.board.entity.Board;
import com.dw.study.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // @Controller인데 모든핸들러에 @ResponseBody어노테이션을 적용해준다.
@RequestMapping("/boards")
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Board board = boardService.findById(id);
        if(board == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(board);
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@Valid @RequestBody BoardCreateDto boardCreateDto) {
        Board board = boardService.save(boardCreateDto.toBoard());
        return ResponseEntity.created(URI.create("/boards" + board.getId())).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @Valid @RequestBody BoardUpdateDto boardUpdateDto) {
        // 한건 조회
        Board board = boardService.findById(id);
        if(board == null)
            return ResponseEntity.notFound().build();
        // 수정
        board = boardUpdateDto.toBoard(board);
        boardService.save(board);
        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
        Board board = boardService.findById(id);
        if(board == null)
            return ResponseEntity.notFound().build();
        boardService.delete(board);
        return ResponseEntity.noContent().build();
    }
}