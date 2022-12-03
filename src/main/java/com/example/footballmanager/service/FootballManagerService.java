package com.example.footballmanager.service;

import com.example.footballmanager.model.FootballPlayer;

public interface FootballManagerService {


    void transferPlayerToAnotherTeam(FootballPlayer player, Long transferToTeamId);
}
