package com.codegym.trello.service.comment;

import com.codegym.trello.model.Card;
import com.codegym.trello.model.Comment;
import com.codegym.trello.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository commentRepository;
    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Iterable<Comment> findAllCommentByCardId(Long cardId) {
        return commentRepository.findAllByCardId(cardId);
    }

    @Override
    public Iterable<Comment> saveAll(Iterable<Comment> comments) {
        return commentRepository.saveAll(comments);
    }

}
