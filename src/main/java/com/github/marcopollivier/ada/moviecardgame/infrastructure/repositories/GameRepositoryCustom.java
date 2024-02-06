package com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.github.marcopollivier.ada.moviecardgame.domain.Game;
import com.github.marcopollivier.ada.moviecardgame.domain.User;

public interface GameRepositoryCustom {
    Optional<Game> findByUserAndIsFinishedFalse(User user);
    List<Game> findByIsFinishedFalse();
}
