package com.github.marcopollivier.ada.moviecardgame.application.service;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcopollivier.ada.moviecardgame.domain.Game;
import com.github.marcopollivier.ada.moviecardgame.domain.Movie;
import com.github.marcopollivier.ada.moviecardgame.domain.Round;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.GameRepository;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.GameRepositoryCustom;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.MovieRepository;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.RoundRepository;


@Service
public class RoundServiceImpl implements RoundService {

    private final RoundRepository roundRepository;
    private final MovieRepository movieRepository;
    private final GameRepository gameRepository;
    private final GameRepositoryCustom gameRepositoryCustom;
    private final GameService gameService;

    @Autowired
    public RoundServiceImpl(
        RoundRepository roundRepository, 
        MovieRepository movieRepository, 
        GameRepository gameRepository,
        GameRepositoryCustom gameRepositoryCustom,
        GameService gameService
        ) {
        this.gameService = gameService;
        this.roundRepository = roundRepository;
        this.movieRepository = movieRepository;
        this.gameRepository = gameRepository;
        this.gameRepositoryCustom = gameRepositoryCustom;
    }

    @Override
    public Round getNextRound() {
        List<Game> unfinishedGames = gameRepositoryCustom.findByIsFinishedFalse();

        if (unfinishedGames.isEmpty()) {
            throw new RuntimeException("Não há jogos em andamento para criar uma nova rodada.");
        }

        Game game = unfinishedGames.get(0);

        List<Movie> movies = movieRepository.findAll();
        if (movies.size() < 2) {
            throw new RuntimeException("Não há filmes suficientes na base de dados para criar uma nova rodada.");
        }

        Random random = new Random();
        int firstIndex = random.nextInt(movies.size());
        int secondIndex;
        do {
            secondIndex = random.nextInt(movies.size());
        } while (secondIndex == firstIndex);

        Movie firstMovie = movies.get(firstIndex);
        Movie secondMovie = movies.get(secondIndex);

        Round round = new Round(game, firstMovie, secondMovie);
        return roundRepository.save(round);
    }

    @Override
    public void respondToRound(Long gameId, Long chosenMovieId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + gameId));
    
        // Round currentRound = game.getCurrentRound();
        // if (currentRound == null) {
        //     throw new RuntimeException("O jogo não possui uma rodada atual.");
        // }
    
        // boolean correctAnswer = currentRound.getMovies().stream()
        //         .anyMatch(movie -> movie.getId().equals(chosenMovieId));
    
        // if (correctAnswer) {
        //     gameService.incrementScore(gameId);
        // } else {
        //     gameService.incrementError(gameId);
        //     if (game.getNumberOfErrors() == 4) {
        //         gameService.finishGame(gameId);
        //     }
        // }
    }

}
