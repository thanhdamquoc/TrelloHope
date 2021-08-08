package com.codegym.trello.service.column;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.Column;
import com.codegym.trello.service.GeneralService;

import java.util.List;

public interface IColumnService extends GeneralService<Column> {
    Iterable<Column> saveAll(Iterable<Column> columns);

}
