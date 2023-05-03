package org.rostekus.hint;

import org.rostekus.game.Game;
import org.rostekus.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HintService {

    public final HintRepository hintRepository;
    public final GameRepository gameRepository;

    @Autowired
    public HintService(HintRepository hintRepository, GameRepository gameRepository) {
        this.hintRepository = hintRepository;
        this.gameRepository = gameRepository;
    }

    public List<Hint> getAllHints() { return hintRepository.findAll(); }

    public void addNewHint(Hint h, UUID gameId) {
        Game g = gameRepository.findById(gameId).orElse(null);
        h.setGame(g);
        hintRepository.save(h);
    }

    public Hint getHintById(UUID id) {
        return hintRepository.findById(id).orElse(null);
    }

    public void deleteHintById(UUID id) {
        hintRepository.deleteById(id);
    }

    public List<Hint> getAllHintsForGame(UUID gameId) {
        return hintRepository.findAllHintsByGameId(gameId);
    }

}
