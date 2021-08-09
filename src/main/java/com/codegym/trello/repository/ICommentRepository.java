package com.codegym.trello.repository;

import com.codegym.trello.model.Card;
import com.codegym.trello.model.Comment;
import com.codegym.trello.model.SimpleBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    Iterable<Comment> findAllByCardId (Long cardId);

}
