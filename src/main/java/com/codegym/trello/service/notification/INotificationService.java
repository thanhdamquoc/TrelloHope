package com.codegym.trello.service.notification;

import com.codegym.trello.model.Notification;
import com.codegym.trello.service.GeneralService;

public interface INotificationService extends GeneralService<Notification> {
    Iterable<Notification> findByUserId(Long userId);
    Iterable<Notification> saveAll(Iterable<Notification> notifications);
    void markAllAsRead(Long userId);
}
