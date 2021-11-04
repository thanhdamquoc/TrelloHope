package com.codegym.trello.service.workspaces;

import com.codegym.trello.model.Workspace;
import com.codegym.trello.service.GeneralService;

public interface WorkspaceService extends GeneralService<Workspace> {
    Iterable<Workspace> findAllByOwnerId (Long id);
    Boolean isBoardInWorkspace(Long boardId);

}
