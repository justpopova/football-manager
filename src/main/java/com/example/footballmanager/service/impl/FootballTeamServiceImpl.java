package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.FootballTeam;
import com.example.footballmanager.repository.FootballTeamRepository;
import com.example.footballmanager.service.FootballTeamService;
import org.springframework.stereotype.Service;

@Service
public class FootballTeamServiceImpl implements FootballTeamService {

    private FootballTeamRepository footballTeamRepository;

    public FootballTeamServiceImpl(FootballTeamRepository footballTeamRepository) {
        this.footballTeamRepository = footballTeamRepository;
    }

    @Override
    public FootballTeam save(FootballTeam footballTeam) {
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public FootballTeam getById(Long id) {
        return footballTeamRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        footballTeamRepository.delete(footballTeamRepository.getReferenceById(id));
    }

    @Override
    public void update(FootballTeam footballTeam) {
        footballTeamRepository.save(footballTeam);
    }
}
