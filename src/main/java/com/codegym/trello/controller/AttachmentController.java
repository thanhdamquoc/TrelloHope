package com.codegym.trello.controller;

import com.codegym.trello.model.Attachment;
import com.codegym.trello.model.Comment;
import com.codegym.trello.service.attachment.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/attachments")
public class AttachmentController {
    @Autowired
    private IAttachmentService attachmentService;

    @GetMapping
    public ResponseEntity<Iterable<Attachment>> findAll() {
        return new ResponseEntity<>(attachmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> findById(@PathVariable Long id) {
        Optional<Attachment> attachmentOptional = attachmentService.findById(id);
        if (!attachmentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachmentOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Attachment> create(@RequestBody Attachment attachment) {
        return new ResponseEntity<>(attachmentService.save(attachment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attachment> update(@PathVariable Long id, @RequestBody Attachment attachment) {
        Optional<Attachment> attachmentOptional = attachmentService.findById(id);
        if (!attachmentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        attachment.setId(attachmentOptional.get().getId());
        return new ResponseEntity<>(attachmentService.save(attachment), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Attachment> delete(@PathVariable Long id) {
        Optional<Attachment> attachmentOptional = attachmentService.findById(id);
        if (!attachmentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        attachmentService.deleteById(id);
        return new ResponseEntity<>(attachmentOptional.get(), HttpStatus.OK);
    }
}
