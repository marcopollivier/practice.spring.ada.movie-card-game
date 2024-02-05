package com.github.marcopollivier.ada.moviecardgame.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcopollivier.ada.moviecardgame.adapter.OmdbAdapter;
import com.github.marcopollivier.ada.moviecardgame.domain.Movie;
import com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    private final OmdbAdapter omdbAdapter;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, OmdbAdapter omdbAdapter) {
        this.movieRepository = movieRepository;
        this.omdbAdapter = omdbAdapter;
    }

    @Override
    public Movie save(Movie movie) {
        var omdbMovie = omdbAdapter.getMovieDetails(movie.getMovieResourceId());

        movie.setVotes(omdbMovie.imdbVotes());
        movie.setScore(omdbMovie.imdbRating());

        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
    
}
