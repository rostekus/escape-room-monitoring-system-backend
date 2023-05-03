package org.rostekus.game;

import org.rostekus.hint.HintRepository;
import org.rostekus.user.User;
import org.rostekus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    public final GameRepository gameRepository;
    public final UserRepository userRepository;
    public final HintRepository hintRepository;
    @Autowired
    public GameService(GameRepository gameRepository, UserRepository userRepository, HintRepository hintRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.hintRepository = hintRepository;
    }

    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }

    public void addNewGame(Game g, String gamemasterEmail) {
        User gm = userRepository.findByEmail(gamemasterEmail).orElse(null);
        g.setGameMaster(gm);
        gameRepository.save(g);
    }

    public Game getGameById(UUID id) {
        return gameRepository.findById(id).orElse(null);
    }

    public void deleteGameMasterById(UUID id) {
        gameRepository.deleteById(id);
    }

    public List<Game> getALlGamesForGameMasterByEmail(String email) {
        User u = userRepository.findByEmail(email).orElse(null);
        return gameRepository.findAllGamesForGameMasterId(u.getId());
    }

    public List<Game> getCurrentGamesForGameMasterById(UUID id) {
        long currentTime = System.currentTimeMillis() / 1000;
        return gameRepository.getGamesWithEndTimestampLessThenNow(currentTime);
    }

    //public List<Hint> getHintToUserById(UUID id) {
      //  return hintRepository.getHintWithTheRequestedId(id);
    //}
}
