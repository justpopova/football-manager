package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.request.FootballPlayerRequestDto;
import com.example.footballmanager.dto.response.FootballPlayerResponseDto;
import com.example.footballmanager.model.FootballPlayer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FootballPlayerMapper {
    private final ModelMapper mapper;

    public FootballPlayerMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public FootballPlayer toModel(FootballPlayerRequestDto dto) {
        return mapper.map(dto, FootballPlayer.class);
    }

    public FootballPlayerResponseDto toDto(FootballPlayer footballPlayer) {
        return mapper.map(footballPlayer, FootballPlayerResponseDto.class);
    }
}
