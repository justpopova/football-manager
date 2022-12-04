package com.example.footballmanager.service;

import com.example.footballmanager.dto.request.FootballTeamRequestDto;
import com.example.footballmanager.model.FootballTeam;
import java.util.List;

public interface FootballTeamService {
    FootballTeam save(FootballTeam footballTeam);

    FootballTeam getById(Long id);

    void delete(Long id);

    FootballTeam update(Long id, FootballTeamRequestDto teamRequestDto);

    List<FootballTeam> getAll();
}
