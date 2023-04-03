package org.rostekus.game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {
    List<Game> findByGameMasterId(UUID gameMasterId);
    @Query("SELECT g FROM game g WHERE g.endTimestamp > :currTime")
    List<Game> getGamesWithEndTimestampLessThenNow(@Param("currTime") long currTime);

}
