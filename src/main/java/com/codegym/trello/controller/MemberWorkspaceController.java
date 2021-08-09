package com.codegym.trello.controller;

import com.codegym.trello.model.MemberWorkspace;
import com.codegym.trello.service.memberworkspace.MemberWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/member-workspace")
public class MemberWorkspaceController {
    @Autowired
    private MemberWorkspaceService memberWorkspaceService;

    @GetMapping("")
    public ResponseEntity<Iterable<MemberWorkspace>> showListTag() {
        return new ResponseEntity<>(memberWorkspaceService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MemberWorkspace> saveTag(@RequestBody MemberWorkspace memberWorkspace) {
        return new ResponseEntity<>(memberWorkspaceService.save(memberWorkspace), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MemberWorkspace>> findTagById(@PathVariable Long id){
        Optional<MemberWorkspace> memberWorkspaceOptional = memberWorkspaceService.findById(id);
        if (!memberWorkspaceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memberWorkspaceOptional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberWorkspace> updateTagById(@PathVariable Long id, @RequestBody MemberWorkspace memberWorkspace){
        Optional<MemberWorkspace> memberWorkspaceOptional = memberWorkspaceService.findById(id);
        if (!memberWorkspaceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberWorkspace.setId(memberWorkspaceOptional.get().getId());
        memberWorkspaceService.save(memberWorkspace);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemberWorkspace> deleteTagById(@PathVariable Long id){
        Optional<MemberWorkspace> workspaceOptional = memberWorkspaceService.findById(id);
        if (!workspaceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberWorkspaceService.deleteById(workspaceOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<MemberWorkspace> deleteAllById(@RequestBody Iterable<MemberWorkspace> memberWorkspaces){
        for (MemberWorkspace memberWorkspace: memberWorkspaces){
            memberWorkspaceService.deleteById(memberWorkspace.getId());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("search/{keyword}/{workspaceId}")
    public ResponseEntity<Iterable<MemberWorkspace>> showListMemberWorkspace(@PathVariable String keyword, @PathVariable Long workspaceId) {
        return new ResponseEntity<>(memberWorkspaceService.findByKeyword(keyword, workspaceId), HttpStatus.OK);
    }
}
