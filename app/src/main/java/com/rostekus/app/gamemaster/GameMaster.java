package com.rostekus.app.gamemaster;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "gamemaster")
@Getter
@Setter
public class GameMaster {
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

    public GameMaster() {
    }

    public GameMaster(String name, String passwordHash, String email, String username) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.email = email;
        this.username = username;
    }

    @Override
    public String toString() {
        return "GameMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
