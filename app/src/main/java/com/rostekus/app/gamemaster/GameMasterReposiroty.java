package com.rostekus.app.gamemaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameMasterReposiroty extends JpaRepository<GameMaster, UUID> {
    @Query("SELECT gm FROM gamemaster gm WHERE gm.email = ?1")
    Optional<GameMaster> findGameMasterByEmail(String email);
}
