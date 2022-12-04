package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.request.FootballTeamRequestDto;
import com.example.footballmanager.exception.EntityNotFoundException;
import com.example.footballmanager.model.FootballTeam;
import com.example.footballmanager.repository.FootballTeamRepository;
import com.example.footballmanager.service.BankAccountService;
import com.example.footballmanager.service.FootballPlayerService;
import com.example.footballmanager.service.FootballTeamService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FootballTeamServiceImpl implements FootballTeamService {

    private final FootballPlayerService playerService;
    private final FootballTeamRepository footballTeamRepository;
    private final BankAccountService bankAccountService;

    public FootballTeamServiceImpl(FootballPlayerService playerService,
                                   FootballTeamRepository footballTeamRepository,
                                   BankAccountService bankAccountService) {
        this.playerService = playerService;
        this.footballTeamRepository = footballTeamRepository;
        this.bankAccountService = bankAccountService;
    }

    @Override
    public FootballTeam save(FootballTeam footballTeam) {
        if (footballTeam.getBankAccount() == null) {
            footballTeam.setBankAccount(bankAccountService.createNewBankAccountForTeam());
            return footballTeamRepository.save(footballTeam);
        }
        return footballTeamRepository.save(footballTeam);
    }

    @Override
    public FootballTeam getById(Long id) {
        if (!footballTeamRepository.existsById(id)) {
            throw new EntityNotFoundException("Don't have football team with id: " + id);
        }
        return footballTeamRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        footballTeamRepository.delete(footballTeamRepository.getReferenceById(id));
    }

    @Override
    public FootballTeam update(Long id, FootballTeamRequestDto teamRequestDto) {
        FootballTeam footballTeam = footballTeamRepository.getReferenceById(id);
        if (teamRequestDto.getName() != null) {
            footballTeam.setName(teamRequestDto.getName());
        }
        if (teamRequestDto.getPlayersIds() != null && !teamRequestDto.getPlayersIds().isEmpty()) {
            footballTeam.setPlayers(playerService.getById(teamRequestDto.getPlayersIds()));
        }
        if (teamRequestDto.getBankAccountId() != null) {
            footballTeam.setBankAccount(bankAccountService.getById(teamRequestDto.getBankAccountId()));
        }
        if (teamRequestDto.getCommission() != 0.0) {
            footballTeam.setCommission(teamRequestDto.getCommission());
        }
        footballTeamRepository.save(footballTeam);
        return footballTeam;
    }

    @Override
    public List<FootballTeam> getAll() {
        return footballTeamRepository.findAll();
    }
}
