package org.rostekus.hint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.rostekus.game.Game;

import java.util.UUID;

@ToString
@Entity(name = "hint")
@Getter
@Setter
public class Hint {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "hint_id",
            updatable = false
    )
    private UUID id;
    @Column(name = "hint_name",
            nullable = false)
    private String name;
    @Column(name = "hint_text",
            nullable = false)
    private String hint_text;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    public Hint() {

    }
    public Hint(String name, String text, Game game) {
        this.name = name;
        this.hint_text = text;
        this.game = game;
    }
}
