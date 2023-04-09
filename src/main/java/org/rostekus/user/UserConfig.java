package org.rostekus.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerGameMaster(UserRepository userRepository) {
        return args -> {
            User u1 = new User(
                    "John",
                    "ddddd",
                    "hello@gmail.com",
                    Role.USER
            );
            User u2 = new User(
                    "John",
                    "ddddd",
                    "hello1@gmail.com",
                    Role.ADMIN
            );
            userRepository.saveAll(
                    List.of(u1, u2)
            );
        };
    }

}
