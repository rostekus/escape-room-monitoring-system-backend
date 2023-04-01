package com.rostekus.app.gamemaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameMasterService {
    private final GameMasterReposiroty gameMasterReposiroty;

    @Autowired
    public GameMasterService(GameMasterReposiroty gameMasterReposiroty) {
        this.gameMasterReposiroty = gameMasterReposiroty;
    }

    public List<GameMaster> getGameAllMaster() {
        return gameMasterReposiroty.findAll();
    }

    public void addNewGameMaster(GameMaster gm) {
        Optional<GameMaster> gmByEmail = gameMasterReposiroty.findGameMasterByEmail(gm.getEmail());
        if (gmByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        gameMasterReposiroty.save(gm);
    }

    public GameMaster getGameMasterById(UUID id) {
        return gameMasterReposiroty.findById(id).orElse(null);
    }

    public void deleteGameMasterById(UUID id) {
        gameMasterReposiroty.deleteById(id);
    }
}