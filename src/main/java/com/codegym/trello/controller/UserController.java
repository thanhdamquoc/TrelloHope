package com.codegym.trello.controller;

import com.codegym.trello.model.SimpleBoard;
import com.codegym.trello.model.User;
import com.codegym.trello.service.board.BoardService;
import com.codegym.trello.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/recoverpassword")
    public ResponseEntity<User> findByUserNameAndNickName(@RequestBody User user){
        User userOptional = userService.findByUsernameAndNickname(user.getUsername(), user.getNickname());
        return new ResponseEntity<>(userOptional, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}/owned-boards")
    public ResponseEntity<Iterable<SimpleBoard>> findAllOwnedBoardsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(boardService.findAllOwnedBoardsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/shared-boards")
    public ResponseEntity<Iterable<SimpleBoard>> findAllSharedBoardsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(boardService.findAllSharedBoardsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/findAll/{username}")
    public ResponseEntity<Iterable<User>> findAllByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userService.findAllByUsername(username), HttpStatus.OK);
    }
}
