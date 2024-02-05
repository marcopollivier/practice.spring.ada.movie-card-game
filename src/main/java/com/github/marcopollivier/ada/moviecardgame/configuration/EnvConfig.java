package com.github.marcopollivier.ada.moviecardgame.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:.env")
public class EnvConfig {

    @Value("${OMDB_HOST}")
    private String omdbHost;

    @Value("${OMDB_API_KEY}")
    private String omdbApiKey;

    public String getOmdbApiKey() {
        return omdbApiKey;
    }

    public String getOmdbHost() {
        return omdbHost;
    }
}
