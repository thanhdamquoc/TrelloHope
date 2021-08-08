package com.codegym.trello.service.column;

import com.codegym.trello.model.Column;
import com.codegym.trello.repository.IColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColumnService implements IColumnService {
    @Autowired
    private IColumnRepository columnRepository;

    @Override
    public Iterable<Column> findAll() {
        return columnRepository.findAll();
    }

    @Override
    public Optional<Column> findById(Long id) {
        return columnRepository.findById(id);
    }

    @Override
    public Column save(Column column) {
        return columnRepository.save(column);
    }

    @Override
    public void deleteById(Long id) {
        columnRepository.deleteById(id);
    }

    @Override
    public Iterable<Column> saveAll(Iterable<Column> columns) {
        return columnRepository.saveAll(columns);
    }


}
