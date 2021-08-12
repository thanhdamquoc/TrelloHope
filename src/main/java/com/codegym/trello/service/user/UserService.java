package com.codegym.trello.service.user;

import com.codegym.trello.model.User;
import com.codegym.trello.service.GeneralService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GeneralService<User>, UserDetailsService {
    User findByUserName(String userName);

    User findByUsernameAndEmail(String username, String email);

    Iterable<User> findUserByKeyword(String keyword);

    Iterable<User> findMembersByBoardId(Long boardId);

    User update(User user);
}
