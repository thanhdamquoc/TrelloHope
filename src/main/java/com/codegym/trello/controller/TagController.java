package com.codegym.trello.controller;

import com.codegym.trello.model.Tag;
import com.codegym.trello.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("")
    public ResponseEntity<Iterable<Tag>> showListTag() {
        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Tag> saveTag(@RequestBody Tag tag) {
        return new ResponseEntity<>(tagService.save(tag), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tag>> findTagById(@PathVariable Long id){
        Optional<Tag> tagOptional = tagService.findById(id);
        if (!tagOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tagOptional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTagById(@PathVariable Long id, @RequestBody Tag tag){
        Optional<Tag> tagOptional = tagService.findById(id);
        if (!tagOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tag.setId(tagOptional.get().getId());
        tagService.save(tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tag> deleteTagById(@PathVariable Long id){
        Optional<Tag> tagOptional = tagService.findById(id);
        if (!tagOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tagService.deleteById(tagOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
