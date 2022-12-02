package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.FootballTeamRequestDto;
import com.example.footballmanager.dto.response.FootballTeamResponseDto;
import com.example.footballmanager.model.FootballTeam;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FootballTeamMapper {
    private final ModelMapper mapper;

    public FootballTeamMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public FootballTeam toModel(FootballTeamRequestDto dto) {
        return mapper.map(dto, FootballTeam.class);
    }

    public FootballTeamResponseDto toDto(FootballTeam footballTeam) {
        return mapper.map(footballTeam, FootballTeamResponseDto.class);
    }
}
