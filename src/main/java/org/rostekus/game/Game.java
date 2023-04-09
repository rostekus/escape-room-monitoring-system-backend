package org.rostekus.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.rostekus.user.User;

import java.util.UUID;

@ToString
@Entity(name = "game")
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "game_id",
            updatable = false
    )
    private UUID id;
    @Column(name = "game_name",
            nullable = false)
    private String name;
    @Column(name = "game_start_timestamp",
            nullable = false
    )
    private long startTimestamp;
    @Column(name = "game_end_timestamp",
            nullable = false
    )
    private long endTimestamp;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gm_id")
    private User gameMaster;

    public Game() {
    }

    public Game(String name, long startTimestamp, long endTimestamp) {
        this.name = name;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public Game(String name, long startTimestamp, long endTimestamp, User gameMaster) {
        this.name = name;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.gameMaster = gameMaster;
    }
}