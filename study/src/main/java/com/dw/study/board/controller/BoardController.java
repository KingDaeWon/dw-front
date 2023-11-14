package com.dw.study.board.controller;

import com.dw.study.board.entity.Board;
import com.dw.study.board.dto.BoardDto;
import com.dw.study.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("/createBoard")
    public ResponseEntity<?> createTravelBoard(@Valid @RequestBody BoardDto boardDto) {
        Board board = boardDto.toBoard();
        return ResponseEntity.ok(boardService.save(board));
    }

    @PatchMapping("/updateBoard/{id}")
    public ResponseEntity<?> updateTravelBoard(@PathVariable Long id, @Valid @RequestBody BoardDto boardDto) {
        // 한건 조회
        Board board = boardService.findById(id);
        if(board == null)
            return ResponseEntity.notFound().build();
        // 수정
        boardDto.toBoard(board);
        boardService.save(board);
        return ResponseEntity.ok(boardService.findById(id));
    }

    @DeleteMapping("/deleteBoard/{id}")
    public ResponseEntity<?> deleteTravelBoard(@PathVariable Long id) {
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}