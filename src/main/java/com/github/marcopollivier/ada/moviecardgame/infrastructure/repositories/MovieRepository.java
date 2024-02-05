package com.github.marcopollivier.ada.moviecardgame.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.marcopollivier.ada.moviecardgame.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{
}
