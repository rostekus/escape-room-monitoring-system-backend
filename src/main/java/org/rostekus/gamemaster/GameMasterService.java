package org.rostekus.gamemaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameMasterService {
    private final GameMasterRepository gameMasterRepository;

    @Autowired
    public GameMasterService(GameMasterRepository gameMasterRepository) {
        this.gameMasterRepository = gameMasterRepository;
    }

    public List<GameMaster> getAllGameMaster() {
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


}