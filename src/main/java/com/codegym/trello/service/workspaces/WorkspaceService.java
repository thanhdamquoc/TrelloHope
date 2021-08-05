package com.codegym.trello.service.workspaces;

import com.codegym.trello.model.Workspaces;
import com.codegym.trello.service.GeneralService;

public interface WorkspaceService extends GeneralService<Workspaces> {
    Iterable<Workspaces> findAllByOwnerId (Long id);
    Boolean isBoardInWorkspace(Long boardId);
}
