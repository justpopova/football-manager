package com.footballmanager.controller;

import com.footballmanager.dto.response.FootballPlayerResponseDto;
import com.footballmanager.mapper.FootballPlayerDtoMapper;
import com.footballmanager.service.FootballManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players-transfer")
public class TransferPlayersController {
    private final FootballManagerService managerService;
    private final FootballPlayerDtoMapper playerDtoMapper;

    public TransferPlayersController(FootballManagerService managerService,
                                     FootballPlayerDtoMapper playerDtoMapper) {
        this.managerService = managerService;
        this.playerDtoMapper = playerDtoMapper;
    }

    @GetMapping("/{playerId}")
    public FootballPlayerResponseDto transferPLayer(@PathVariable Long playerId,
                                                    @RequestParam Long footballTeamId) {
        return playerDtoMapper.mapToDto(
                managerService.transferPlayerToAnotherTeam(playerId, footballTeamId));
    }
}