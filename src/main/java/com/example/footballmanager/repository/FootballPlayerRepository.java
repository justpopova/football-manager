package com.example.footballmanager.repository;

import com.example.footballmanager.model.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, Long> {
}
