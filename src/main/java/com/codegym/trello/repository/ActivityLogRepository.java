package com.codegym.trello.repository;

import com.codegym.trello.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    Iterable<ActivityLog> findByBoardId (Long boardId);
}
