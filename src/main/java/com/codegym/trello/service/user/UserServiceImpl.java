package com.codegym.trello.service.user;

import com.codegym.trello.model.User;
import com.codegym.trello.model.UserPrincipal;
import com.codegym.trello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return UserPrincipal.build(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User findByUsernameAndNickname(String username, String nickname) {
        return userRepository.findByUsernameAndNickname(username, nickname);
    }

    @Override
    public Iterable<User> findAllByUsername(String username) {
        return userRepository.findAllByUsername("%"+ username+ "%");
    }


}
