package com.codegym.trello.service.reply;

import com.codegym.trello.model.Reply;
import com.codegym.trello.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReplyService implements IReplyService{
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public Iterable<Reply> findAll() {
        return replyRepository.findAll();
    }

    @Override
    public Optional<Reply> findById(Long id) {
        return replyRepository.findById(id);
    }

    @Override
    public Reply save(Reply reply) {
        return replyRepository.save(reply);
    }

    @Override
    public void deleteById(Long id) {
        replyRepository.deleteById(id);
    }

}
