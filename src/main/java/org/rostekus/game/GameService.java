package org.rostekus.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class GameService {

    public final GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    public void addNewGame(Game g) {
        gameRepository.save(g);
    }

    public Game getGameById(UUID id) {
        return gameRepository.findById(id).orElse(null);
    }

    public void deleteGameMasterById(UUID id) {
        gameRepository.deleteById(id);
    }

    public List<Game> getALlGamesForGameMasterById(UUID id) {
       return gameRepository.findAllGamesForGameMasterId(id);
    }

    public List<Game> getCurrentGamesForGameMasterById(UUID id) {
        long currentTime = System.currentTimeMillis() / 1000;
        return gameRepository.getGamesWithEndTimestampLessThenNow(currentTime);
    }
}
