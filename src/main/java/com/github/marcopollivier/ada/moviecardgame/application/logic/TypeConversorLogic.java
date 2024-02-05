package com.github.marcopollivier.ada.moviecardgame.application.logic;

public class TypeConversorLogic {
    
    public static int usIntegerFormatToInteger(String numeroFormatado) {
        return Integer.parseInt(numeroFormatado.replace(",", ""));
    }
}