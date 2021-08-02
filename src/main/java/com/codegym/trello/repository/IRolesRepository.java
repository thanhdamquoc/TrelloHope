package com.codegym.trello.repository;

import com.codegym.trello.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesRepository extends JpaRepository<Roles, Long> {
}
