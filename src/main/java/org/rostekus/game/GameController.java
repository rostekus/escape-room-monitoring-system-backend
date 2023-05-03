package org.rostekus.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGame() {
        return gameService.getAllGame();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void postGame(@RequestBody Game g) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String gamemasterEmail =authentication.getName();
        gameService.addNewGame(g, gamemasterEmail);
    }

    //  ==========================================================
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Game getGameById(@PathVariable UUID id) {
        return gameService.getGameById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable UUID id) {
        gameService.deleteGameMasterById(id);
    }

    @GetMapping("/gamemasters")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Game> getALlGamesForGameMasterById() {
        return gameService.getAllGame();
    }

//    @GetMapping("/gamemasters/{id}/current")
//    public List<Game> getCurrentGameMasterGames(@PathVariable UUID id) {
//        return gameService.getCurrentGamesForGameMasterById(id);
//    }
}
