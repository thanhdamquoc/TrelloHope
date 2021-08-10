package com.codegym.trello.controller;

import com.codegym.trello.model.Member;
import com.codegym.trello.model.User;
import com.codegym.trello.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public ResponseEntity<Iterable<Member>> showListMember() {
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<Iterable<Member>> saveMembers(@RequestBody Iterable<Member> members) {
        return new ResponseEntity<>(memberService.saveAll(members), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Member>> findMemberById(@PathVariable Long id) {
        Optional<Member> memberOptional = memberService.findById(id);
        if (!memberOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memberOptional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Optional<Member> memberOptional = memberService.findById(id);
        if (!memberOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        member.setId(memberOptional.get().getId());
        memberService.save(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteMemberById(@PathVariable Long id){
        Optional<Member> memberOptional = memberService.findById(id);
        if (!memberOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberService.deleteById(memberOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    @DeleteMapping("/{boardId}/{userId}")
    public ResponseEntity<Member> deleteMemberWorkspace(@PathVariable Long boardId, @PathVariable Long userId ){
        memberService.deleteByBoardIdAndUserId(boardId,userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
