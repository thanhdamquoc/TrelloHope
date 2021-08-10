package com.codegym.trello.repository;

import com.codegym.trello.model.Reply;
import com.codegym.trello.model.SimpleBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {


}
