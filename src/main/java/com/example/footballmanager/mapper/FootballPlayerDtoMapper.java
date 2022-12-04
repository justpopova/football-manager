package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.FootballPlayerRequestDto;
import com.example.footballmanager.dto.response.FootballPlayerResponseDto;
import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.service.FootballTeamService;
import org.springframework.stereotype.Component;

@Component
public class FootballPlayerDtoMapper implements RequestDtoMapper<FootballPlayerRequestDto, FootballPlayer>,
        ResponseDtoMapper<FootballPlayerResponseDto, FootballPlayer> {
    private final FootballTeamService teamService;

    public FootballPlayerDtoMapper(FootballTeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public FootballPlayer mapToModel(FootballPlayerRequestDto dto) {
        FootballPlayer player = new FootballPlayer();
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setYearsExperience(dto.getYearsExperience());
        player.setFootballTeam(teamService.getById(dto.getFootballTeamId()));
        return player;
    }

    @Override
    public FootballPlayerResponseDto mapToDto(FootballPlayer player) {
        FootballPlayerResponseDto responseDto = new FootballPlayerResponseDto();
        responseDto.setId(player.getId());
        responseDto.setName(player.getName());
        responseDto.setAge(player.getAge());
        responseDto.setYearsExperience(player.getYearsExperience());
        if (player.getFootballTeam() != null) {
            responseDto.setFootballTeamId(player.getFootballTeam().getId());
        }
        return responseDto;
    }
}
