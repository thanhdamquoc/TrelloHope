package com.codegym.trello.repository;

import com.codegym.trello.model.MemberWorkspace;
import com.codegym.trello.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberWorkspaceRepository extends JpaRepository<MemberWorkspace, Long> {
    @Query(nativeQuery = true,value = "select mw.* " +
            "from member_workspace as mw " +
            "         join user u on u.id = mw.user_id " +
            "        join workspace_members wm on mw.id = wm.members_id " +
            "join workspace w on w.id = wm.workspace_id " +
            "where (u.username like ?1 or u.nickname like ?1) and w.id =?2")
    Iterable<MemberWorkspace> findByKeyword(String keyword, Long workspaceId);
}
