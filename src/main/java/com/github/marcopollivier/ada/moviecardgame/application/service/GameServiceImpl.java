package com.github.marcopollivier.ada.moviecardgame.application.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcopollivier.ada.moviecardgame.domain.Game;
import com.github.marcopollivier.ada.moviecardgame.domain.User;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.GameRepository;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.GameRepositoryCustom;

@Service
public class GameServiceImpl implements GameService {

    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private final GameRepository gameRepository;
    private final GameRepositoryCustom gameRepositoryCustom;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, GameRepositoryCustom gameRepositoryCustom) {
        this.gameRepository = gameRepository;
        this.gameRepositoryCustom = gameRepositoryCustom;
    }

    @Override
    public Game startGame(User user) {
        Optional<Game> existingGame = gameRepositoryCustom.findByUserAndIsFinishedFalse(user);
        if (existingGame.isPresent()) {
            log.error("O usuário já tem um jogo em aberto.");
            return existingGame.get();
        }

        Game newGame = new Game("Novo Jogo", user);
        
        log.info("Novo jogo iniciado com sucesso para o usuário: " + user.getUserName() + ".");
        return gameRepository.save(newGame);
    }

    @Override
    public void finishGame(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + gameId));

        game.setIsFinished(true);
        gameRepository.save(game);
    }

    @Override
    public void incrementScore(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + gameId));

        int currentScore = game.getScore();
        game.setScore(currentScore + 1);

        gameRepository.save(game);
    }

    @Override
    public void incrementError(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + gameId));

        int currentErrors = game.getNumberOfErrors();
        game.setNumberOfErrors(currentErrors + 1);

        gameRepository.save(game);
    }
}
