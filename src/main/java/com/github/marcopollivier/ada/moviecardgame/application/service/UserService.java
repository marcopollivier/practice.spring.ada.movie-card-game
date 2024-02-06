package com.github.marcopollivier.ada.moviecardgame.application.service;

import java.io.IOException;

import com.github.marcopollivier.ada.moviecardgame.domain.User;

public interface UserService {
    User save(User user) throws IOException; 
}
