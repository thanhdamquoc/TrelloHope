package com.codegym.trello.controller;
import com.codegym.trello.model.Notification;
import com.codegym.trello.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private INotificationService notificationService;

    @GetMapping
    public ResponseEntity<Iterable<Notification>> findAll() {
        return new ResponseEntity<>(notificationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Iterable<Notification>> findByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(notificationService.findByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody Notification notification) {
        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> update(@PathVariable Long id, @RequestBody Notification notification) {
        Optional<Notification> notificationOptional = notificationService.findById(id);
        if (!notificationOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        notification.setId(notificationOptional.get().getId());
        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Notification> delete(@PathVariable Long id) {
        Optional<Notification> notificationOptional = notificationService.findById(id);
        if (!notificationOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        notificationService.deleteById(id);
        return new ResponseEntity<>(notificationOptional.get(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Iterable<Notification>> saveNotifications(@RequestBody Iterable<Notification> notifications) {
        return new ResponseEntity<>(notificationService.saveAll(notifications), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/read-all")
    public ResponseEntity<Iterable<Notification>> markAllAsRead(@RequestBody Long userId) {
        notificationService.markAllAsRead(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
