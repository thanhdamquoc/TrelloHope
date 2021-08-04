package com.codegym.trello.service.board;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.Column;
import com.codegym.trello.model.SimpleBoard;
import com.codegym.trello.model.User;
import com.codegym.trello.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Iterable<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Board findByIdSorted(Long id) {
        Board board = boardRepository.findById(id).get();
        for (Column column : board.getColumns()) {
            Collections.sort(column.getCards());
        }
        Collections.sort(board.getColumns());
        return board;
    }

    @Override
    public Iterable<Board> findAllByOwner(User owner) {
        return boardRepository.findAllByOwner(owner);
    }

    @Override
    public Iterable<SimpleBoard> findAllOwnedBoardsByUserId(Long userId) {
        return boardRepository.findAllOwnedBoardsByUserId(userId);
    }

    @Override
    public Iterable<SimpleBoard> findAllSharedBoardsByUserId(Long userId) {
        return boardRepository.findAllSharedBoardsByUserId(userId);
    }
}
