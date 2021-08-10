package com.codegym.trello.service.attachment;

import com.codegym.trello.model.Attachment;
import com.codegym.trello.repository.IAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachmentService implements IAttachmentService{
    @Autowired
    private IAttachmentRepository attachmentRepository;
    @Override
    public Iterable<Attachment> findAll() {
        return attachmentRepository.findAll();
    }

    @Override
    public Optional<Attachment> findById(Long id) {
        return attachmentRepository.findById(id);
    }

    @Override
    public Attachment save(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public void deleteById(Long id) {
        attachmentRepository.deleteById(id);
    }

    @Override
    public Iterable<Attachment> findAttachmentsByCard_Id(Long cardId) {
        return attachmentRepository.findAttachmentsByCard_Id(cardId);
    }
}
