package com.footballmanager.controller;

import com.footballmanager.dto.request.FootballPlayerRequestDto;
import com.footballmanager.dto.response.FootballPlayerResponseDto;
import com.footballmanager.mapper.FootballPlayerDtoMapper;
import com.footballmanager.model.FootballPlayer;
import com.footballmanager.service.FootballPlayerService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public FootballPlayerResponseDto create(@RequestBody @Valid FootballPlayerRequestDto dto) {
        FootballPlayer player = footballPlayerService.save(playerDtoMapper.mapToModel(dto));
        return playerDtoMapper.mapToDto(player);
    }

    @GetMapping("/{id}")
    public FootballPlayerResponseDto getById(@PathVariable Long id) {
        FootballPlayer player = footballPlayerService.getAllByIds(id);
        return playerDtoMapper.mapToDto(player);
    }

    @PutMapping("/{id}")
    public FootballPlayerResponseDto update(@PathVariable Long id,
                                            @RequestBody FootballPlayerRequestDto dto) {
        FootballPlayer player = footballPlayerService.update(id, dto);
        return playerDtoMapper.mapToDto(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballPlayerService.delete(id);
    }

    @GetMapping("/by-team")
    public List<FootballPlayerResponseDto> getPlayersByTeam(
            @RequestParam(name = "team-id") Long teamId) {
        return footballPlayerService.getPlayersByTeam(teamId).stream()
                .filter(p -> p.getFootballTeam().getId().equals(teamId))
                .map(playerDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<FootballPlayerResponseDto> getAllPlayers() {
        return footballPlayerService.getAll().stream()
                .map(playerDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
