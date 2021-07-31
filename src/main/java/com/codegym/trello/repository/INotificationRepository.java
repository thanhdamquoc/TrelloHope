package com.codegym.trello.repository;

import com.codegym.trello.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
    @Query(nativeQuery = true, value = "select * " +
            "from notification " +
            "         join notification_receiver nr on notification.id = nr.notification_id " +
            "where nr.receiver_id = ?1 order by id desc limit 99")
    Iterable<Notification> findByUserId(Long userId);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update notification " +
            "join notification_receiver nr on notification.id = nr.notification_id " +
            "set notification.status = true " +
            "where nr.receiver_id = ?1")
    void markAllAsRead(Long userId);
}
