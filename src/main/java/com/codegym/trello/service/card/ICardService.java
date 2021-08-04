package com.codegym.trello.service.card;

import com.codegym.trello.model.Card;
import com.codegym.trello.service.GeneralService;

public interface ICardService extends GeneralService<Card> {
    Iterable<Card> saveAll(Iterable<Card> cards);
}
