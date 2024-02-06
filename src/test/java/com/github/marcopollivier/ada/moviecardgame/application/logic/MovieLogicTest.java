package com.github.marcopollivier.ada.moviecardgame.application.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.github.marcopollivier.ada.moviecardgame.domain.Movie;

public class MovieLogicTest {
    
    @ParameterizedTest
    @CsvSource(value = {
            "5.0:1:5.0",
            "5.0:10:50.0",
            "10000.0:10000:100000000.0",
            "7.8:50552:394305.6",
    }, delimiter = ':')
    public void testConverterParaInteiro(Double score, int votes, Double expected) {
        //Arrange
        Movie movie = new Movie("Anatomia de uma Queda", "tt17009710");
        movie.setScore(score);
        movie.setVotes(votes);

        // Act
        double resultado = MovieLogic.movieScore(movie);

        // Assert
        assertEquals(expected, resultado);
    }
}
