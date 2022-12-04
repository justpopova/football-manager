package com.example.footballmanager.service;

import com.example.footballmanager.dto.request.FootballPlayerRequestDto;
import com.example.footballmanager.model.FootballPlayer;
import java.util.List;

public interface FootballPlayerService {
    FootballPlayer save(FootballPlayer footballTeam);

    FootballPlayer getById(Long id);

    List<FootballPlayer> getById(List<Long> ids);

    void delete(Long id);

    FootballPlayer update(Long id, FootballPlayerRequestDto requestDto);

    List<FootballPlayer> getPlayersByTeam(Long id);

    List<FootballPlayer> getAll();
}
