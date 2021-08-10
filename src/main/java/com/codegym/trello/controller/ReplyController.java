package com.codegym.trello.controller;

import com.codegym.trello.model.Reply;
import com.codegym.trello.service.reply.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/replies")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("")
    public ResponseEntity<Iterable<Reply>> showListReply() {
        return new ResponseEntity<>(replyService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Reply> saveReply(@RequestBody Reply reply) {
        return new ResponseEntity<>(replyService.save(reply), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reply>> findReplyById(@PathVariable Long id){
        Optional<Reply> replyOptional = replyService.findById(id);
        if (!replyOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(replyOptional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reply> updateReplyById(@PathVariable Long id, @RequestBody Reply reply){
        Optional<Reply> replyOptional = replyService.findById(id);
        if (!replyOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reply.setId(replyOptional.get().getId());
        replyService.save(reply);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reply> deleteReplyById(@PathVariable Long id){
        Optional<Reply> replyOptional = replyService.findById(id);
        if (!replyOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        replyService.deleteById(replyOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
