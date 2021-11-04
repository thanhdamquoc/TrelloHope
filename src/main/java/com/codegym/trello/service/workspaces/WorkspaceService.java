package com.codegym.trello.service.workspaces;

public interface WorkspaceService extends GeneralService<Workspaces> {
    Iterable<Workspaces> findAllByOwnerId (Long id);
    Boolean isBoardInWorkspace(Long boardId);

}
