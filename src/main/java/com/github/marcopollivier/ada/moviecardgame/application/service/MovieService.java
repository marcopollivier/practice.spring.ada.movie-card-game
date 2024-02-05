package com.github.marcopollivier.ada.moviecardgame.application.service;

import java.io.IOException;
import java.util.List;

import com.github.marcopollivier.ada.moviecardgame.domain.Movie;

public interface MovieService {
    Movie save(Movie movie) throws IOException; 

    Movie getMovieById(String id);
    List<Movie> findAll();
}
