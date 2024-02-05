package com.github.marcopollivier.ada.moviecardgame.application.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TypeConversorLogicTests {

    @ParameterizedTest
    @CsvSource(value = {
            "001:1",
            "501:501",
            "5001:5001",
            "5,001:5001",
            "50,001:50001",
            "500,001:500001",
    }, delimiter = ':')
    public void testConverterParaInteiro(String usNumber, Integer expected) {
        // Act
        int resultado = TypeConversorLogic.usIntegerFormatToInteger(usNumber);

        // Assert
        assertEquals(expected, resultado, "A conversão para inteiro não está correta para " + usNumber);
    }

}


// usIntegerFormatToInteger