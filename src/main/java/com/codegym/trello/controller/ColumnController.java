package com.codegym.trello.controller;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.Column;
import com.codegym.trello.service.column.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/columns")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @GetMapping("/{board}")
    public ResponseEntity<Iterable<Column>> findAllByBoard(@PathVariable Long board) {
        return new ResponseEntity<>(columnService.findAllByBoard(board), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Column> save(@RequestBody Column column) {
        return new ResponseEntity<>(columnService.save(column), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Column> update(@PathVariable Long id, @RequestBody Column column) {
        Optional<Column> optionalColumn = columnService.findById(id.longValue());
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
