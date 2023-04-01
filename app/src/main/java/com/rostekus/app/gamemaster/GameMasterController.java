package com.rostekus.app.gamemaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/gamemasters")
public class GameMasterController {

    private final GameMasterService gameMasterService;

    @Autowired
    public GameMasterController(GameMasterService gameMasterService) {
        this.gameMasterService = gameMasterService;
    }

    @GetMapping
    public List<GameMaster> getGameMaster() {
        return gameMasterService.getGameAllMaster();
    }

    @PostMapping
    public void registerNewGameMaster(@RequestBody GameMaster gm) {
        gameMasterService.addNewGameMaster(gm);
    }

    @GetMapping("/{id}")
    public GameMaster getGameMasterById(@PathVariable UUID id) {
        return gameMasterService.getGameMasterById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGameMaster(@PathVariable UUID id) {
        gameMasterService.deleteGameMasterById(id);
    }

}
