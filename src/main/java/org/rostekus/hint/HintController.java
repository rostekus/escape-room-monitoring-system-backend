package org.rostekus.hint;

import org.rostekus.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/hints")
public class HintController {
    private final HintService hintService;

    @Autowired HintController(HintService hintService) { this.hintService = hintService; }

    @GetMapping
    public List<Hint> getHint() { return hintService.getAllHints(); }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void postHint(@RequestBody Hint h, @PathVariable UUID id) {
        Game g = hintService.gameRepository.findById(id).orElse(null);
        hintService.addNewHint(h, g.getId());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Hint getHintById(@PathVariable UUID id) { return hintService.getHintById(id); }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteHint(@PathVariable UUID id) { hintService.deleteHintById(id); }

    @GetMapping("/{game}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Hint> getAllHintsId(@PathVariable UUID id) { return hintService.getAllHintsForGame(id); }
}
