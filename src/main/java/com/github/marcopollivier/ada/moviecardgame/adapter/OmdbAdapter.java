package com.github.marcopollivier.ada.moviecardgame.adapter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcopollivier.ada.moviecardgame.application.logic.TypeConversorLogic;
import com.github.marcopollivier.ada.moviecardgame.configuration.EnvConfig;
import com.github.marcopollivier.ada.moviecardgame.domain.OmdbMovie;

@Service
public class OmdbAdapter {

private static final Logger log = LoggerFactory.getLogger(OmdbAdapter.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final EnvConfig envConfig;

    @Autowired
    public OmdbAdapter(RestTemplate restTemplate, ObjectMapper objectMapper, EnvConfig envConfig) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.envConfig = envConfig;
    }

    public OmdbMovie getMovieDetails(String omdbMovieId) {
        String url = buildOmdbUrl(omdbMovieId);
    
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            return parseOmdbResponse(jsonResponse);
        } catch (Exception e) {
            log.error("Erro ao obter detalhes do filme com ID: " + omdbMovieId, e);
            return new OmdbMovie(null, null, null);
        }
    }
    
    private String buildOmdbUrl(String omdbMovieId) {
        var omdbHost = envConfig.getOmdbHost();
        var omdbApiKey = envConfig.getOmdbApiKey();
        return String.format("%s/?apikey=%s&i=%s", omdbHost, omdbApiKey, omdbMovieId);
    }
    
    private OmdbMovie parseOmdbResponse(String jsonResponse) {
        Integer imdbVotes = null;
        Double imdbRating = null;
        String imdbID = null;
    
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            var stringVotes = jsonNode.get("imdbVotes").asText();
            imdbVotes = TypeConversorLogic.usIntegerFormatToInteger(stringVotes);
            imdbRating = jsonNode.get("imdbRating").asDouble();
            imdbID = jsonNode.get("imdbID").asText();
        } catch (IOException e) {
            log.error("Erro ao analisar a resposta do filme", e);
        }
    
        return new OmdbMovie(imdbVotes, imdbRating, imdbID);
    }
}
