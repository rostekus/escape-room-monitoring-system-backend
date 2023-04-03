package org.rostekus.game;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    @Bean
    CommandLineRunner commandLineRunnerGame(GameRepository gameRepository) {
        return args -> {
            Game game = new Game("My Game", System.currentTimeMillis()/1000, System.currentTimeMillis() /1000 +600);
            gameRepository.save(game);
        };
    }
}
