package com.footballmanager.service.impl;

import com.footballmanager.dto.request.FootballTeamRequestDto;
import com.footballmanager.exception.EntityNotFoundException;
import com.footballmanager.model.FootballTeam;
import com.footballmanager.repository.FootballTeamRepository;
import com.footballmanager.service.BankAccountService;
import com.footballmanager.service.FootballPlayerService;
import com.footballmanager.service.FootballTeamService;
import java.util.List;
import org.springframework.stereotype.Service;

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
        if (!footballTeamRepository.existsById(id)) {
            throw new EntityNotFoundException("Team with id " + id + " doesn't exist");
        }

        FootballTeam footballTeam = footballTeamRepository.getReferenceById(id);
        if (teamRequestDto.getName() != null) {
            footballTeam.setName(teamRequestDto.getName());
        }
        if (teamRequestDto.getPlayersIds() != null && !teamRequestDto.getPlayersIds().isEmpty()) {
            footballTeam.setPlayers(playerService.getById(teamRequestDto.getPlayersIds()));
        }
        if (teamRequestDto.getBankAccountId() != null) {
            footballTeam.setBankAccount(
                    bankAccountService.getById(teamRequestDto.getBankAccountId()));
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
