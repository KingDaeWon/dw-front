package com.dw.study.board.controller;

import com.dw.study.board.dto.BoardCreateDto;
import com.dw.study.board.dto.BoardSearchDto;
import com.dw.study.board.dto.BoardUpdateDto;
import com.dw.study.board.entity.Board;
import com.dw.study.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<?> findAll(@PageableDefault(value = 5, page = 0) Pageable pageable){
        // di받지 않는다면... Pageable객체 직접 생성
//        Pageable pageable = PageRequest.of(0, 5);
        Page<Board> result = boardService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/totalCount")
    public ResponseEntity<?> getTotalCount() {
        return ResponseEntity.ok(boardService.getTotalCount());
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByBoardContentLike(@RequestParam String boardContent) {
        return ResponseEntity.ok(boardService.findByBoardContentLike(boardContent));
    }
    @GetMapping("/search2")
    public ResponseEntity<?> findByBoardContentLikeAndMemberMemberNameLike(@RequestParam String boardContent, @RequestParam String memberName) {
        return ResponseEntity.ok(boardService.findByBoardContentLikeAndMemberMemberNameLike(boardContent, memberName));
    }
    @GetMapping("/search3")
    public ResponseEntity<?> findByExample(BoardSearchDto boardSearchDto) {
        log.debug("boardSearchDto = {}", boardSearchDto);
        return ResponseEntity.ok(boardService.findByExample(boardSearchDto.toBoard()));
    }

//    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> findById(@PathVariable Long boardId) {
        Board board = boardService.findById(boardId);
        if(board == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(board);
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@Valid @RequestBody BoardCreateDto boardCreateDto) {
        Board board = boardService.save(boardCreateDto.toBoard());
        return ResponseEntity.created(URI.create("/boards" + board.getBoardId())).build();
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<?> updateBoard(@PathVariable Long boardId, @Valid @RequestBody BoardUpdateDto boardUpdateDto) {
        Board board = boardService.findById(boardId);
        if(board == null)
            return ResponseEntity.notFound().build();
        // 수정
        board = boardUpdateDto.toBoard(board);
        System.out.println("board :" + board);
        boardService.save(board);
        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long boardId) {
        Board board = boardService.findById(boardId);
        if(board == null)
            return ResponseEntity.notFound().build();
        boardService.delete(board);
        return ResponseEntity.noContent().build();
    }
}