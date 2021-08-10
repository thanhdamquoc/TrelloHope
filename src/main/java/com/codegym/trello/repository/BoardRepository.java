package com.codegym.trello.repository;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.SimpleBoard;
import com.codegym.trello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Iterable<Board> findAllByOwner(User owner);

    @Query(value = "select b.id, b.title, u.username as owner " +
            "from board b " +
            "join user u on b.owner_id = u.id " +
            "where b.owner_id = ?1 " +
            "order by b.id desc",
            nativeQuery = true)
    Iterable<SimpleBoard> findAllOwnedBoardsByUserId(Long userId);

    @Query(value = "select b.id, b.title, u.username as owner " +
            "from board b " +
            "join user u on b.owner_id = u.id " +
            "where b.id in " +
            "(select m.board_id from member m where m.user_id = ?1) " +
            "order by b.id desc", nativeQuery = true)
    Iterable<SimpleBoard> findAllSharedBoardsByUserId(Long userId);

    @Query(value = "select * from board b " +
            "where ((b.owner_id = ?2) or (b.id in (select m.board_id from member m where m.user_id = ?2))) " +
            "and ((b.title like ?1) or (b.owner_id in (select u.id from user u where u.username like ?1))) " +
            "limit 5", nativeQuery = true)
    Iterable<Board> findAllByKeyword(String keyword, Long searcherId);
}
