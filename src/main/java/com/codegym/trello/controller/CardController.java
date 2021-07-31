package com.codegym.trello.controller;

import com.codegym.trello.model.Card;
import com.codegym.trello.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<Iterable<Card>> findAll() {
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@RequestParam Long id) {
        Optional<Card> optionalColumn = cardService.findById(id);
        if (!optionalColumn.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalColumn.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        return new ResponseEntity<>(cardService.save(card), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@RequestParam Long id, @RequestBody Card card) {
        Optional<Card> optionalCard = cardService.findById(id);
        if (!optionalCard.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            card.setId(id);
            return new ResponseEntity<>(cardService.save(card), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> deleteById(@RequestParam Long id) {
        Optional<Card> cardOptional = cardService.findById(id);
        if (!cardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cardOptional.get(), HttpStatus.NO_CONTENT);
        }
    }
}
