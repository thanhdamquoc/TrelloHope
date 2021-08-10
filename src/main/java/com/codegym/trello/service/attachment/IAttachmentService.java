package com.codegym.trello.service.attachment;

import com.codegym.trello.model.Attachment;
import com.codegym.trello.service.GeneralService;

public interface IAttachmentService extends GeneralService<Attachment> {
    Iterable<Attachment> findAttachmentsByCard_Id(Long cardId);
}
