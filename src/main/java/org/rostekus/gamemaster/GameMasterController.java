package org.rostekus.gamemaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public List<GameMaster> getGameMaster() {
        return gameMasterService.getAllGameMaster();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED, reason = "OK")
    public void postGameMaster(@RequestBody GameMaster gm) {
        gameMasterService.addNewGameMaster(gm);
    }
    //  ==========================================================
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public GameMaster getGameMasterById(@PathVariable UUID id) {
        return gameMasterService.getGameMasterById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGameMaster(@PathVariable UUID id) {
        gameMasterService.deleteGameMasterById(id);
    }


}
