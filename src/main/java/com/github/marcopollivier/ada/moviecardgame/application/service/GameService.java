package com.github.marcopollivier.ada.moviecardgame.application.service;

import com.github.marcopollivier.ada.moviecardgame.domain.Game;
import com.github.marcopollivier.ada.moviecardgame.domain.User;

public interface GameService {
    Game startGame(User user);
    void finishGame(Long gameId);
    void incrementScore(Long gameId);
    void incrementError(Long gameId);
}
