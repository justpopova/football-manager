package com.example.footballmanager.service;

import com.example.footballmanager.model.FootballTeam;

public interface FootballTeamService {
    FootballTeam save(FootballTeam footballTeam);

    FootballTeam getById(Long id);

    void delete(Long id);

    void update(FootballTeam footballTeam);
}
