package com.github.marcopollivier.ada.moviecardgame.application.logic;

import com.github.marcopollivier.ada.moviecardgame.domain.Movie;

public class MovieLogic {

    private MovieLogic() { }

    public static Double movieScore(Movie movie) {
        return movie.getScore() * movie.getVotes();
    }

}
