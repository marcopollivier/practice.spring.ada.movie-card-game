package com.github.marcopollivier.ada.moviecardgame.domain;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private double score;
    private int votes;
    private String movieResourceId; 

    public Movie() {
    }

    public Movie(String id, String title, String movieResourceId) {
        this.id = id;
        this.title = title;
        this.movieResourceId = movieResourceId;
    }

    public Movie(String title, String movieResourceId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.movieResourceId = movieResourceId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", votes=" + votes +
                ", movieResourceId='" + movieResourceId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getMovieResourceId() {
        return movieResourceId;
    }

    public String getTitle() {
        return title;
    }

    public int getVotes() {
        return votes;
    }

    public double getScore() {
        return score;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
