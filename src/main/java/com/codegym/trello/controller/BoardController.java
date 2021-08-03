package com.codegym.trello.controller;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.Card;
import com.codegym.trello.model.Column;
import com.codegym.trello.service.board.BoardService;
import com.codegym.trello.service.card.ICardService;
import com.codegym.trello.service.column.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private IColumnService columnService;

    @Autowired
    private ICardService cardService;

    @GetMapping
    public ResponseEntity<Iterable<Board>> findAll() {
        return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> findById(@PathVariable Long id) {
        Optional<Board> boardOptional = boardService.findById(id);
        if (!boardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(boardOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}/sorted")
    public ResponseEntity<Board> findByIdSorted(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.findByIdSorted(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Board> add(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.save(board), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody Board board) {
        return new ResponseEntity<>(boardService.save(board), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Board> deleteById(@PathVariable Long id) {
        Optional<Board> boardOptional = boardService.findById(id);
        if (!boardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boardService.deleteById(id);
        return new ResponseEntity<>(boardOptional.get(), HttpStatus.NO_CONTENT);
    }
}
