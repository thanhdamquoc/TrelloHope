package com.codegym.trello.service.notification;

import com.codegym.trello.model.Notification;
import com.codegym.trello.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class NotificationService implements INotificationService{
    @Autowired
    private INotificationRepository notificationRepository;

    @Override
    public Iterable<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Iterable<Notification> findByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public Iterable<Notification> saveAll(Iterable<Notification> notifications) {
        return notificationRepository.saveAll(notifications);
    }

    @Override
    public void markAllAsRead(Long userId) {
       notificationRepository.markAllAsRead(userId);
    }
}
