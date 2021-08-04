package com.codegym.trello.repository;

import com.codegym.trello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndNickname(String username, String nickname);

    @Query(nativeQuery = false, value = "select u from User as u where u.username like ?1")
    Iterable<User> findAllByUsername(String username);
}
