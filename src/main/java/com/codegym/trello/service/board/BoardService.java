package com.codegym.trello.service.board;

import com.codegym.trello.model.Board;
import com.codegym.trello.model.SimpleBoard;
import com.codegym.trello.model.User;
import com.codegym.trello.service.GeneralService;

public interface BoardService extends GeneralService<Board> {
    Board findByIdSorted(Long id);
    Iterable<Board> findAllByOwner(User owner);
    Iterable<SimpleBoard> findAllOwnedBoardsByUserId(Long userId);
    Iterable<SimpleBoard> findAllSharedBoardsByUserId(Long userId);
    Iterable<Board> findAllAvailableToSearcher(Long searcherId);
}
