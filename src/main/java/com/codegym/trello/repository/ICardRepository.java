package com.codegym.trello.repository;

import com.codegym.trello.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {
    @Query(value = "select * from card where column_id in" +
            "(select column_id from columns where board_id = ?1)", nativeQuery = true)
    public Iterable<Card> findCardsByBoardId(Long boardId);
}
