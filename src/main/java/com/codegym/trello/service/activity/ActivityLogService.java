package com.codegym.trello.service.activity;

import com.codegym.trello.model.ActivityLog;
import com.codegym.trello.service.GeneralService;

public interface ActivityLogService extends GeneralService<ActivityLog> {
    Iterable<ActivityLog> findByBoardId (Long boardId);
}
