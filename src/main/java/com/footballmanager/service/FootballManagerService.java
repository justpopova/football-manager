package com.footballmanager.service;

import com.footballmanager.model.FootballPlayer;

public interface FootballManagerService {
    FootballPlayer transferPlayerToAnotherTeam(Long playerId, Long transferToTeamId);
}
