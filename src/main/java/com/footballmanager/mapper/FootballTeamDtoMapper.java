package com.footballmanager.mapper;

import com.footballmanager.dto.request.FootballTeamRequestDto;
import com.footballmanager.dto.response.FootballTeamResponseDto;
import com.footballmanager.model.FootballPlayer;
import com.footballmanager.model.FootballTeam;
import com.footballmanager.service.BankAccountService;
import com.footballmanager.service.FootballPlayerService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FootballTeamDtoMapper implements
        RequestDtoMapper<FootballTeamRequestDto, FootballTeam>,
        ResponseDtoMapper<FootballTeamResponseDto, FootballTeam> {
    private final BankAccountService bankAccountService;
    private final FootballPlayerService playerService;

    public FootballTeamDtoMapper(BankAccountService bankAccountService,
                                 FootballPlayerService playerService) {
        this.bankAccountService = bankAccountService;
        this.playerService = playerService;
    }

    @Override
    public FootballTeam mapToModel(FootballTeamRequestDto dto) {
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setName(dto.getName());
        if (dto.getBankAccountId() == null) {
            footballTeam.setBankAccount(bankAccountService.createNewBankAccountForTeam());
        } else {
            footballTeam.setBankAccount(bankAccountService.getById(dto.getBankAccountId()));
        }
        footballTeam.setCommission(dto.getCommission());
        if (dto.getPlayersIds() != null) {
            footballTeam.setPlayers(dto.getPlayersIds().stream()
                    .map(playerService::getById)
                    .collect(Collectors.toList()));
        }
        return footballTeam;
    }

    @Override
    public FootballTeamResponseDto mapToDto(FootballTeam footballTeam) {
        FootballTeamResponseDto responseDto = new FootballTeamResponseDto();
        responseDto.setId(footballTeam.getId());
        responseDto.setName(footballTeam.getName());
        responseDto.setBankAccountId(footballTeam.getBankAccount().getId());
        responseDto.setCommission(footballTeam.getCommission());
        if (footballTeam.getPlayers() != null) {
            responseDto.setPlayersIds(footballTeam.getPlayers().stream()
                    .map(FootballPlayer::getId)
                    .collect(Collectors.toList()));
        }
        return responseDto;
    }
}
