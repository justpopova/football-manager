package com.example.footballmanager.controller;

import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.service.FootballManagerService;
import com.example.footballmanager.service.FootballPlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players-transfer")
public class TransferPlayersController {
    private final FootballManagerService managerService;
    private final FootballPlayerService playerService;

    public TransferPlayersController(FootballManagerService managerService,
                                     FootballPlayerService playerService) {
        this.managerService = managerService;
        this.playerService = playerService;
    }

    @GetMapping("/{playerId}")
    public void transferPLayer(@PathVariable  Long playerId,
                               @RequestParam Long footballTeamId) {
        FootballPlayer player = playerService.getById(playerId);
        managerService.transferPlayerToAnotherTeam(player, footballTeamId);
    }
}
