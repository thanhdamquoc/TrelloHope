package com.codegym.trello.service.user;

import com.codegym.trello.model.User;
import com.codegym.trello.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GeneralService<User>, UserDetailsService {
    User findByUserName(String userName);

    User findByUsernameAndNickname(String username, String nickname);

}
