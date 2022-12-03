package com.example.footballmanager.service;

import com.example.footballmanager.model.FootballPlayer;

import java.util.List;

public interface FootballPlayerService {
    FootballPlayer save(FootballPlayer footballTeam);

    FootballPlayer getById(Long id);

    void delete(Long id);

    void update(FootballPlayer footballTeam);

    List<FootballPlayer> getAll();
}
