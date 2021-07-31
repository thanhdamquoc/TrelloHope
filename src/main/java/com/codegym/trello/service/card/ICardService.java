package com.codegym.trello.service.card;

import com.codegym.trello.model.Card;
import com.codegym.trello.service.GeneralService;

public interface ICardService extends GeneralService<Card> {
    public Iterable<Card> findCardsByBoardId(Long boardId);
}
