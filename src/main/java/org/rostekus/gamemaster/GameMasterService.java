package org.rostekus.gamemaster;

import org.rostekus.game.Game;
import org.rostekus.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameMasterService {
    private final GameMasterRepository gameMasterRepository;
    private final GameRepository gameRepository;

    @Autowired
    public GameMasterService(GameMasterRepository gameMasterRepository, GameRepository gameRepository) {
        this.gameMasterRepository = gameMasterRepository;
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGamesForGameMaster(UUID gameMasterId) {
        Optional<GameMaster> gameMasterOptional = gameMasterRepository.findById(gameMasterId);
        if (!gameMasterOptional.isPresent()) {
            return Collections.emptyList();
        }
        return gameRepository.findByGameMasterId(gameMasterId);
    }

    public List<GameMaster> getGameAllMaster() {
        return gameMasterRepository.findAll();
    }

    public void addNewGameMaster(GameMaster gm) {
        Optional<GameMaster> gmByEmail = gameMasterRepository.findGameMasterByEmail(gm.getEmail());
        if (gmByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        gameMasterRepository.save(gm);
    }

    public GameMaster getGameMasterById(UUID id) {
        return gameMasterRepository.findById(id).orElse(null);
    }

    public void deleteGameMasterById(UUID id) {
        gameMasterRepository.deleteById(id);
    }


    public List<Game> getCurrentGameMasterGames(UUID id) {
        long currentTime = System.currentTimeMillis() / 1000;
        return gameRepository.getGamesWithEndTimestampLessThenNow(currentTime);
    }

    public void addGameForGameMaster(UUID id, Game g) {
        Optional<GameMaster> gm = gameMasterRepository.findById(id);

         if (gm.isEmpty()) {
            throw new IllegalStateException("gamemaster does not exit");
        }
        g.setGameMaster(gm.get());
        gameRepository.save(g);
    }
}