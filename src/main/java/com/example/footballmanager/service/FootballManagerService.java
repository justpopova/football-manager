package com.example.footballmanager.service;

import com.example.footballmanager.model.FootballPlayer;

public interface FootballManagerService {
    FootballPlayer transferPlayerToAnotherTeam(Long playerId, Long transferToTeamId);
}
