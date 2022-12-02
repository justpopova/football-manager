package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.FootballTeamRequestDto;
import com.example.footballmanager.dto.response.FootballTeamResponseDto;
import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.model.FootballTeam;
import com.example.footballmanager.repository.FootballPlayerRepository;
import com.example.footballmanager.service.FootballTeamService;

import java.util.stream.Collectors;

public class FootballTeamDtoMapper implements RequestDtoMapper<FootballTeamRequestDto,
        FootballTeam>, ResponseDtoMapper<FootballTeamResponseDto, FootballTeam> {

    private final FootballTeamService footballTeamService;
    private final FootballPlayerRepository repository;

    public FootballTeamDtoMapper(FootballTeamService footballTeamService,
                                 FootballPlayerRepository repository) {
        this.footballTeamService = footballTeamService;
        this.repository = repository;
    }


    @Override
    public FootballTeam mapToModel(FootballTeamRequestDto dto) {
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setName(dto.getName());
//        footballTeam.setPlayers(dto.getPlayersIds()
//                .stream()
//                .map()
//                .collect(Collectors.toList()));
        return footballTeam;
    }

    @Override
    public FootballTeamResponseDto mapToDto(FootballTeam footballTeam) {
        FootballTeamResponseDto responseDto = new FootballTeamResponseDto();
        responseDto.setId(footballTeam.getId());
        responseDto.setName(footballTeam.getName());
        responseDto.setPlayersIds(footballTeam.getPlayers()
                .stream()
                .map(FootballPlayer::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
