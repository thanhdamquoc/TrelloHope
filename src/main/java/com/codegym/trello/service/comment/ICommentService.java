package com.codegym.trello.service.comment;

import com.codegym.trello.model.Comment;
import com.codegym.trello.service.GeneralService;

public interface ICommentService extends GeneralService<Comment> {
    Iterable<Comment> findAllCommentByCardId(Long cardId);

    Iterable<Comment> saveAll(Iterable<Comment> comments);

}
