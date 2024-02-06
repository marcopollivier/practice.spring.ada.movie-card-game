package com.github.marcopollivier.ada.moviecardgame.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String gameTitle;
    private Boolean isFinished = false;
    private Integer score = 0;
    private Integer numberOfErrors = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "game")
    private List<Round> rounds = new ArrayList<>();

    // Construtores
    public Game() {
    }

    public Game(String gameTitle, User user) {
        this.gameTitle = gameTitle;
        this.user = user;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean finished) {
        isFinished = finished;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getNumberOfErrors() {
        return numberOfErrors;
    }

    public void setNumberOfErrors(Integer numberOfErrors) {
        this.numberOfErrors = numberOfErrors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Round getCurrentRound() {
        if (rounds.isEmpty()) {
            return null;
        }
        return rounds.get(rounds.size() - 1); 
    }

    // Método toString
    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", isFinished=" + isFinished +
                ", score=" + score +
                ", numberOfErrors=" + numberOfErrors +
                ", user=" + user +
                '}';
    }
}
