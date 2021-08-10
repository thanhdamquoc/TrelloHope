package com.codegym.trello.repository;

import com.codegym.trello.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachmentRepository extends JpaRepository<Attachment, Long> {
    Iterable<Attachment> findAttachmentsByCard_Id(Long cardId);
}
