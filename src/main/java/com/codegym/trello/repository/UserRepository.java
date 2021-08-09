package com.codegym.trello.repository;

import com.codegym.trello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndEmail(String username, String email);

    @Query(value = "select * from user u " +
            "where u.username " +
            "like ?1 or u.nickname like ?1", nativeQuery = true)
    Iterable<User> findUserByKeyword(String keyword);

    @Query(value = "select u.* " +
            "from member m " +
            "join user u on m.user_id = u.id " +
            "where board_id = ?1", nativeQuery = true)
    Iterable<User> findMembersByBoardId(Long boardId);
}
