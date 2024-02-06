package com.github.marcopollivier.ada.moviecardgame.application.service;

import com.github.marcopollivier.ada.moviecardgame.domain.Round;

public interface RoundService {

    Round getNextRound();
    void respondToRound(Long gameId, Long chosenMovieId);

}