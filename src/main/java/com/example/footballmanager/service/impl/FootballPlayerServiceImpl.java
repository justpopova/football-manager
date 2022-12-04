package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.request.FootballPlayerRequestDto;
import com.example.footballmanager.exception.EntityNotFoundException;
import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.repository.FootballPlayerRepository;
import com.example.footballmanager.repository.FootballTeamRepository;
import com.example.footballmanager.service.FootballPlayerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FootballPlayerServiceImpl implements FootballPlayerService {
    private final FootballPlayerRepository footballPlayerRepository;
    private final FootballTeamRepository teamRepository;

    public FootballPlayerServiceImpl(FootballPlayerRepository footballPlayerRepository,
                                     FootballTeamRepository teamRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public FootballPlayer save(FootballPlayer footballPLayer) {
        return footballPlayerRepository.save(footballPLayer);
    }

    @Override
    public FootballPlayer getById(Long id) {
        if (!footballPlayerRepository.existsById(id)) {
            throw new EntityNotFoundException("Don't have football player with id: " + id);
        }
        return footballPlayerRepository.getReferenceById(id);
    }

    @Override
    public List<FootballPlayer> getById(List<Long> id) {
        return footballPlayerRepository.findAllById(id);
    }

    @Override
    public void delete(Long id) {
        footballPlayerRepository.delete(footballPlayerRepository.getReferenceById(id));
    }

    @Override
    public FootballPlayer update(Long id, FootballPlayerRequestDto requestDto) {
        FootballPlayer footballPlayer = footballPlayerRepository.getReferenceById(id);
        if (requestDto.getName() != null) {
            footballPlayer.setName(requestDto.getName());
        }
        if (requestDto.getAge() != 0) {
            footballPlayer.setAge(requestDto.getAge());
        }
        if (requestDto.getYearsExperience() != 0.0) {
            footballPlayer.setYearsExperience(requestDto.getYearsExperience());
        }
        if (requestDto.getFootballTeamId() != null) {
            footballPlayer.setFootballTeam(teamRepository.getReferenceById(requestDto.getFootballTeamId()));
        }
        footballPlayerRepository.save(footballPlayer);
        return footballPlayer;
    }

    @Override
    public List<FootballPlayer> getPlayersByTeam(Long id) {
        return footballPlayerRepository.getAllByFootballTeamId(id);
    }

    @Override
    public List<FootballPlayer> getAll() {
        return footballPlayerRepository.findAll();
    }
}
