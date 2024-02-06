package com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.marcopollivier.ada.moviecardgame.domain.Game;
import com.github.marcopollivier.ada.moviecardgame.domain.User;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByUserAndIsFinishedFalse(User user);
}
