package com.codegym.trello.service.member;

import com.codegym.trello.model.DetailedMember;
import com.codegym.trello.model.Member;
import com.codegym.trello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService implements IMemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Iterable<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Iterable<DetailedMember> getMembersByBoardId(Long boardId) {
        return memberRepository.getMembersByBoardId(boardId);
    }

    @Override
    public Iterable<Member> saveAll(Iterable<Member> members) {
        return memberRepository.saveAll(members);
    }

    @Override
    public void deleteByBoardIdAndUserId(Long boardId, Long userId){
        memberRepository.deleteByBoardIdAndUserId(boardId,userId);
    }
}
