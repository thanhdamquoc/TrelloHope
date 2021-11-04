package com.codegym.trello.service.member;

import com.codegym.trello.model.DetailedMember;
import com.codegym.trello.model.Member;
import com.codegym.trello.service.GeneralService;

public interface IMemberService extends GeneralService<Member> {
    Iterable<DetailedMember> getMembersByBoardId(Long boardId);
    Iterable<Member> saveAll(Iterable<Member> members);
    void deleteByBoardIdAndUserId(Long boardId, Long userId);
}
