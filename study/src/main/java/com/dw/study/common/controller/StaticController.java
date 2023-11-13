package com.dw.study.common.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class StaticController {

    @GetMapping("/api/hello")
    public String test() {
        return "안녕, 김대원입니다.";
    }
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String boardList() {
        return "forward:/boards/board_list.html";
    }

    @RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
    public String boardDetail() {
        return "forward:/boards/board_detail.html";
    }

    @RequestMapping(value = "/board/create", method = RequestMethod.GET)
    public String boardCreate() {
        return "forward:/boards/board_create.html";
    }

    @RequestMapping(value = "/board/update/{id}", method = RequestMethod.GET)
    public String boardUpdate() {
        return "forward:/boards/board_update.html";
    }
}