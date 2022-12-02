package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.FootballTeamRequestDto;
import com.example.footballmanager.mapper.FootballTeamMapper;
import com.example.footballmanager.model.FootballTeam;
import com.example.footballmanager.service.FootballTeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-team")
public class FootballTeamController {

    private final FootballTeamMapper teamMapper;
    private final FootballTeamService footballTeamService;

    public FootballTeamController(FootballTeamMapper teamMapper, FootballTeamService footballTeamService) {
        this.teamMapper = teamMapper;
        this.footballTeamService = footballTeamService;
    }

    @PostMapping
    public FootballTeam create(FootballTeamRequestDto dto) {
       return footballTeamService.save(teamMapper.toModel(dto));
    }
}
