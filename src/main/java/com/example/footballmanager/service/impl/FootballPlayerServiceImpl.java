package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.repository.FootballPlayerRepository;
import com.example.footballmanager.service.FootballPlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballPlayerServiceImpl implements FootballPlayerService {
    private final FootballPlayerRepository footballPlayerRepository;

    public FootballPlayerServiceImpl(FootballPlayerRepository footballPlayerRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
    }

    @Override
    public FootballPlayer save(FootballPlayer footballPLayer) {
        return footballPlayerRepository.save(footballPLayer);
    }

    @Override
    public FootballPlayer getById(Long id) {
        return footballPlayerRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        footballPlayerRepository.delete(footballPlayerRepository.getReferenceById(id));
    }

    @Override
    public void update(FootballPlayer footballPlayer) {
        footballPlayerRepository.save(footballPlayer);
    }

    @Override
    public List<FootballPlayer> getAll() {
        return footballPlayerRepository.findAll();
    }
}
