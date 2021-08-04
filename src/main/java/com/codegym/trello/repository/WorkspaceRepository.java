package com.codegym.trello.repository;

import com.codegym.trello.model.Workspaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspaces, Long> {
    Iterable<Workspaces> findAllByOwnerId (Long id);

}
