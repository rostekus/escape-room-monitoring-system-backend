package org.rostekus.hint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HintRepository extends JpaRepository<Hint, UUID> {

    @Query("SELECT h FROM hint h WHERE h.gameId = :id")
    List<Hint> findAllHintsByGameId(@Param("id") UUID id);
}
