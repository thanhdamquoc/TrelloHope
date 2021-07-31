package com.codegym.trello.repository;

import com.codegym.trello.model.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColumnRepository extends JpaRepository<Column, Long> {
}
