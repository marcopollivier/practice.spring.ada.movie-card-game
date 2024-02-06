package com.github.marcopollivier.ada.moviecardgame.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Game game;

    @ManyToMany
    @JoinTable(
            name = "round_movie",
            joinColumns = @JoinColumn(name = "round_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();

    // Construtor
    public Round() {
    }

    public Round(Game game, List<Movie> movies) {
        this.game = game;
        this.movies = movies;
    }

    public Round(Game game, Movie firstMovie, Movie secondMovie) {
        this.game = game;
        this.movies.add(firstMovie);
        this.movies.add(secondMovie);
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    // Método toString
    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", game=" + game +
                ", movies=" + movies +
                '}';
    }
}
