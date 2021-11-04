package com.codegym.trello.repository;

import com.codegym.trello.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    @Query(nativeQuery = true, value = "select * " +
            "from workspace w " +
            "where w.owner_id = ?1 " +
            "   or w.id in " +
            "      (select wm.workspace_id " +
            "       from workspace_members wm " +
            "                join member_workspace mw on wm.members_id = mw.id " +
            "       where mw.user_id = ?1)")
    Iterable<Workspace> findAllByOwnerId(Long id);

    @Query(nativeQuery = true,
            value = "select count(*) " +
                    "from workspace_boards wb " +
                    "where wb.boards_id = ?1")
    Integer isBoardInWorkspace(Long boardId);

}
