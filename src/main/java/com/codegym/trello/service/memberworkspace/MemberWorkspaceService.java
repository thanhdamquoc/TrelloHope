package com.codegym.trello.service.memberworkspace;

import com.codegym.trello.model.MemberWorkspace;
import com.codegym.trello.model.Workspace;
import com.codegym.trello.service.GeneralService;

public interface MemberWorkspaceService extends GeneralService<MemberWorkspace> {
    Iterable<MemberWorkspace> findByKeyword(String keyword, Long workspaceId);
}
