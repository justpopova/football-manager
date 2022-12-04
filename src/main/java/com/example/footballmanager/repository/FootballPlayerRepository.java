package com.example.footballmanager.repository;

import com.example.footballmanager.model.FootballPlayer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, Long> {
    List<FootballPlayer> getAllByFootballTeamId(Long id);
}
