package com.github.marcopollivier.ada.moviecardgame.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    public record ApplicationHealth(String status) { }

    @GetMapping("/health")
    public ApplicationHealth healthCheck() {
        return new ApplicationHealth("ok");
    }

}