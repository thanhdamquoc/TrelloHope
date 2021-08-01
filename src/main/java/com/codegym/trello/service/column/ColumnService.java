package com.codegym.trello.service.column;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.Card;
import com.codegym.trello.model.Column;
import com.codegym.trello.repository.IColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
    public Iterable<Column> findAllByBoard(Long board){
        Iterable<Column> columns = columnRepository.findColumnByBoardId(board);
        for(Column column : columns){
            Collections.sort(column.getCard());
            List<Card> cardList = column.getCard();
            for (Card card : cardList){
                System.out.println(card.getPosition());
            }
            column.setCard(cardList);
        }
        return columns;
    }
}
