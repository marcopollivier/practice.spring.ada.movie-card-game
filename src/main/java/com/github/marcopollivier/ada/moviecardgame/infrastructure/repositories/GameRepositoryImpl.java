package com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.github.marcopollivier.ada.moviecardgame.domain.Game;
import com.github.marcopollivier.ada.moviecardgame.domain.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class GameRepositoryImpl implements GameRepositoryCustom {

    @Autowired
    @Lazy
    private GameRepository gameRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Game> findByUserAndIsFinishedFalse(User user) {
        String jpql = "SELECT g FROM Game g WHERE g.user.id = :userId AND g.isFinished = false";
        TypedQuery<Game> query = entityManager.createQuery(jpql, Game.class);
        query.setParameter("userId", user.getId());
        List<Game> games = query.getResultList();
        return games.isEmpty() ? Optional.empty() : Optional.of(games.get(0));
    }

    @Override
    public List<Game> findByIsFinishedFalse() {
        String jpql = "SELECT g FROM Game g WHERE g.isFinished = false";
        TypedQuery<Game> query = entityManager.createQuery(jpql, Game.class);
        return query.getResultList();
    }

}
