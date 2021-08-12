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
            "where (b.id in " +
            "(select m.board_id from member m where m.user_id = ?1)) " +
            "and (b.owner_id <> ?1) " +
            "order by b.id desc", nativeQuery = true)
    Iterable<SimpleBoard> findAllSharedBoardsByUserId(Long userId);

    @Query(value = "select * from board b " +
            "where ((b.owner_id = ?1) or (b.id in (select m.board_id from member m where m.user_id = ?1))) ", nativeQuery = true)
    Iterable<Board> findAllAvailableToSearcher(Long searcherId);
}
