package com.codegym.trello.service.card;

import com.codegym.trello.model.Card;
import com.codegym.trello.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;

    @Override
    public Iterable<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<Card> findById(Long id) {
        return cardRepository.findById(id);
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public Iterable<Card> saveAll(Iterable<Card> cards) {
        return cardRepository.saveAll(cards);
    }
}
