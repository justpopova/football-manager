package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.FootballPlayerRequestDto;
import com.example.footballmanager.dto.response.FootballPlayerResponseDto;
import com.example.footballmanager.mapper.FootballPlayerDtoMapper;
import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.service.FootballPlayerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-players")
public class FootballPlayerController {
    private final FootballPlayerDtoMapper playerDtoMapper;
    private final FootballPlayerService footballPlayerService;

    public FootballPlayerController(FootballPlayerDtoMapper playerDtoMapper,
                                    FootballPlayerService footballPlayerService) {
        this.playerDtoMapper = playerDtoMapper;
        this.footballPlayerService = footballPlayerService;
    }

    @PostMapping
    public FootballPlayerResponseDto create(@RequestBody FootballPlayerRequestDto dto) {
        FootballPlayer player = footballPlayerService.save(playerDtoMapper.mapToModel(dto));
        return playerDtoMapper.mapToDto(player);
    }

    @GetMapping("/get-player-by-id/{id}")
    public FootballPlayerResponseDto getById(@PathVariable Long id) {
        FootballPlayer player = footballPlayerService.getById(id);
        return playerDtoMapper.mapToDto(player);
    }

    @PutMapping("/update-player-by-id/{id}")
    public FootballPlayerResponseDto update(@PathVariable Long id,
                                            @RequestBody FootballPlayerRequestDto dto) {
        FootballPlayer player = playerDtoMapper.mapToModel(dto);
        player.setId(id);
        footballPlayerService.update(player);
        return playerDtoMapper.mapToDto(player);
    }

    @DeleteMapping("/delete-player-by-id/{id}")
    public void delete(@PathVariable Long id) {
        footballPlayerService.delete(id);
    }
}
