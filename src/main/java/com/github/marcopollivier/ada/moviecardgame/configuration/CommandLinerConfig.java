package com.github.marcopollivier.ada.moviecardgame.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.marcopollivier.ada.moviecardgame.application.service.MovieService;
import com.github.marcopollivier.ada.moviecardgame.domain.Movie;

@Configuration
public class CommandLinerConfig {

    private static final Logger log = LoggerFactory.getLogger(CommandLinerConfig.class);
    
	@Bean
	public CommandLineRunner demo(MovieService movieService) {
		return (args) -> {
			movieService.save(new Movie("Anatomia de uma Queda", "tt17009710")); //7.8
			movieService.save(new Movie("Assassinos da Lua das Flores", "tt5537002")); //7.7
			movieService.save(new Movie("Barbie", "tt1517268")); //6.9
			movieService.save(new Movie("Ficção Americana", "tt23561236")); //7.9
			movieService.save(new Movie("Maestro", "tt5535276")); //6.6
			movieService.save(new Movie("Oppenheimer", "tt15398776")); // 8.4
			movieService.save(new Movie("Os Rejeitados", "tt14849194")); //8.0
			movieService.save(new Movie("Pobres Criaturas", "tt14230458")); //8.4
			movieService.save(new Movie("Vidas Passadas", "tt13238346")); //7.9
			movieService.save(new Movie("Zona de Interesse", "tt7160372")); //7.9

			log.info("Movies found with findAll():");
			log.info("--------------------------------");
			movieService.findAll().forEach(movie -> {
				log.info(movie.toString());
			});
			log.info("--------------------------------");

		};
	}

}
