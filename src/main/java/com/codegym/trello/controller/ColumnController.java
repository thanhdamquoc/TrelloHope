package com.codegym.trello.controller;

import com.codegym.trello.model.Column;
import com.codegym.trello.service.column.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/columns")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @GetMapping
    public ResponseEntity<Iterable<Column>> findAll() {
        return new ResponseEntity<>(columnService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Column> findById(@PathVariable Long id) {
        Optional<Column> optionalColumn = columnService.findById(id);
        if (!optionalColumn.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalColumn.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Column> save(@RequestBody Column column) {
        return new ResponseEntity<>(columnService.save(column), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Iterable<Column>> saveAll(@RequestBody Iterable<Column> columns) {
        return new ResponseEntity<>(columnService.saveAll(columns), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Column> update(@PathVariable Long id, @RequestBody Column column) {
        Optional<Column> optionalColumn = columnService.findById(id);
        if (!optionalColumn.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            column.setId(id);
            return new ResponseEntity<>(columnService.save(column), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Column> deleteById(@PathVariable Long id) {
        Optional<Column> optionalColumn = columnService.findById(id);
        if (!optionalColumn.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalColumn.get(), HttpStatus.NO_CONTENT);
        }
    }
}
