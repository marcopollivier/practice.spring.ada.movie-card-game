package com.github.marcopollivier.ada.moviecardgame.application.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcopollivier.ada.moviecardgame.domain.User;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) throws IOException {
        if (user == null) {
            throw new IOException("User cannot be null");
        }

        return userRepository.save(user);
    }
    
}
