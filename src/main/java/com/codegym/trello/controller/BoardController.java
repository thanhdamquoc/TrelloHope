package com.codegym.trello.controller;

import com.codegym.trello.model.*;
import com.codegym.trello.service.board.BoardService;
import com.codegym.trello.service.member.IMemberService;
import com.codegym.trello.service.workspaces.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private IMemberService memberService;

    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping
    public ResponseEntity<Iterable<Board>> findAll() {
        return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> findById(@PathVariable Long id) {
        Optional<Board> boardOptional = boardService.findById(id);
        if (!boardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(boardOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}/sorted")
    public ResponseEntity<Board> findByIdSorted(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.findByIdSorted(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Board> add(@RequestBody Board board) {
        Board savedBoard = boardService.save(board);
        //create owner as the first member of board
        Member member = new Member(null, savedBoard.getOwner(), true, savedBoard);
        Member savedMember = memberService.save(member);
        System.out.println(savedMember);
        return new ResponseEntity<>(savedBoard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody Board board) {
        return new ResponseEntity<>(boardService.save(board), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Board> deleteById(@PathVariable Long id) {
        Optional<Board> boardOptional = boardService.findById(id);
        if (!boardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<Iterable<DetailedMember>> findMembersByBoardId(@PathVariable Long id) {
        return new ResponseEntity<>(memberService.getMembersByBoardId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/is-in-workspace")
    public ResponseEntity<Boolean> isBoardInWorkspace(@PathVariable Long id) {
        return new ResponseEntity<>(workspaceService.isBoardInWorkspace(id), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<MemberWorkspace> deleteAllById(@RequestBody Iterable<Board> boards) {
        for (Board board : boards) {
            boardService.deleteById(board.getId());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/available-to/{searcherId}")
    public ResponseEntity<Iterable<Board>> findAllAvailableToSearcher(@PathVariable Long searcherId) {
        return new ResponseEntity<>(boardService.findAllAvailableToSearcher(searcherId), HttpStatus.OK);
    }
}
