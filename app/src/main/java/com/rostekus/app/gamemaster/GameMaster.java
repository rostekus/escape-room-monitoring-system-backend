package com.rostekus.app.gamemaster;

import com.rostekus.app.game.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "gamemaster")
@Getter
@Setter
public class GameMaster implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "gm_id",
            updatable = false
    )
    private UUID id;
    @Column(name = "gm_name",
            nullable = false)
    private String name;
    @Column(name = "gm_password_hash",
            nullable = false)
    private String passwordHash;
    @Column(name = "gm_email",
            nullable = false,
            unique = true
    )
    private String email;
    @Column(name = "gm_username",
            nullable = false
    )
    private String username;


    @OneToMany(mappedBy = "gameMaster", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Game> games;

    public GameMaster() {
    }

    public GameMaster(String name, String passwordHash, String email, String username) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.email = email;
        this.username = username;
    }

    @Override
    public GameMaster clone() {
        try {
            GameMaster clone = (GameMaster) super.clone();
            // Clone any mutable fields here
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


}
