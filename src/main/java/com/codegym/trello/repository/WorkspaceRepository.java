package com.codegym.trello.repository;

import com.codegym.trello.model.User;
import com.codegym.trello.model.Workspaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspaces, Long> {
    @Query(nativeQuery = true, value = "select * from workspaces as w join workspaces_members wm on w.id = wm.workspaces_id where w.owner_id = ?1 or wm.members_id = ?1 group by workspaces_id")
    Iterable<Workspaces> findAllByOwnerId(Long id);

}
