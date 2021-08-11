package com.codegym.trello.controller;

import com.codegym.trello.model.Board;
import com.codegym.trello.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController("*")
@CrossOrigin
public class WebSocketController {
    @Autowired
    private BoardService boardService;

    @MessageMapping("/boards")
    @SendTo("/topic/boards")
    public Board createNewBoard(Board board) {
        return boardService.save(board);
    }
}
