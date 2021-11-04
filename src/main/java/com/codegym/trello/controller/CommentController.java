package com.codegym.trello.controller;

import com.codegym.trello.model.Card;
import com.codegym.trello.model.Comment;
import com.codegym.trello.service.card.ICardService;
import com.codegym.trello.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    private ICardService cardService;

    @GetMapping
    public ResponseEntity<Iterable<Comment>> findAll() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{cardId}/comment-card")
    public ResponseEntity<Iterable<Comment>> findAllCommentByCardId(@PathVariable Long cardId){
        return new ResponseEntity<>(commentService.findAllCommentByCardId(cardId), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Iterable<Comment>> saveAll(@RequestBody Iterable<Comment> comments) {
        return new ResponseEntity<>(commentService.saveAll(comments), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(commentOptional.get().getId());
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> delete(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
