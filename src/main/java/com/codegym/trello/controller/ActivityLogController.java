package com.codegym.trello.controller;

import com.codegym.trello.model.ActivityLog;
import com.codegym.trello.service.activity.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("activityLog")
public class ActivityLogController {
    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping
    public ResponseEntity<Iterable<ActivityLog>> findAll() {
        return new ResponseEntity<>(activityLogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Iterable<ActivityLog>> findByBoardId(@PathVariable Long boardId) {
        return new ResponseEntity<>(activityLogService.findByBoardId(boardId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityLog> create(@RequestBody ActivityLog activity) {
        return new ResponseEntity<>(activityLogService.save(activity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityLog> update(@PathVariable Long id, @RequestBody ActivityLog activity) {
        Optional<ActivityLog> activityLogOptional = activityLogService.findById(id);
        if (!activityLogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        activity.setId(activityLogOptional.get().getId());
        return new ResponseEntity<>(activityLogService.save(activity), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ActivityLog> delete(@PathVariable Long id) {
        Optional<ActivityLog> activityLogOptional = activityLogService.findById(id);
        if (!activityLogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        activityLogService.deleteById(id);
        return new ResponseEntity<>(activityLogOptional.get(), HttpStatus.OK);
    }

}
