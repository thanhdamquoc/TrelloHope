package com.codegym.trello.repository;

import com.codegym.trello.model.MemberWorkspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberWorkspaceRepository extends JpaRepository<MemberWorkspace, Long> {
}