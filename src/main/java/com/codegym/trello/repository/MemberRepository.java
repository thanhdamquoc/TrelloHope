package com.codegym.trello.repository;

import com.codegym.trello.model.DetailedMember;
import com.codegym.trello.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select m.id, m.user_id as userId, " +
            "m.board_id as boardId, m.can_edit as canEdit, " +
            "u.username, u.nickname, u.image " +
            "from member m " +
            "join user u on m.user_id = u.id " +
            "where m.board_id = ?1", nativeQuery = true)
    Iterable<DetailedMember> getMembersByBoardId(Long boardId);

    @Query(value = "select m.id, m.user_id as userId, m.board_id as boardId, m.can_edit as canEdit, " +
            "u.username, u.nickname, u.image from member m " +
            "join user u on m.user_id = u.id " +
            "where u.id = ?1", nativeQuery = true)
    Iterable<DetailedMember> getMemberByUserId(Long userId);

    void deleteByBoardIdAndUserId(Long boardId, Long userId);
}
