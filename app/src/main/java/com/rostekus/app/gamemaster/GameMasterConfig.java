package com.rostekus.app.gamemaster;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameMasterConfig {
    @Bean
    CommandLineRunner commandLineRunner(GameMasterReposiroty gameMasterReposiroty) {
        return args -> {
            GameMaster gm1 = new GameMaster(
                    "John",
                    "ddddd",
                    "hello@gmail.com",
                    "john"
            );
            GameMaster gm2 = new GameMaster(
                    "John",
                    "ddddd",
                    "hello1@gmail.com",
                    "john1"
            );
            gameMasterReposiroty.saveAll(
                    List.of(gm1, gm2)
            );
        };
    }

}
