package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.FootballTeamRequestDto;
import com.example.footballmanager.dto.response.FootballTeamResponseDto;
import com.example.footballmanager.mapper.FootballTeamMapper;
import com.example.footballmanager.model.FootballTeam;
import com.example.footballmanager.service.FootballTeamService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public FootballTeamResponseDto create(@RequestBody FootballTeamRequestDto dto) {
        FootballTeam footballTeam = footballTeamService.save(teamMapper.toModel(dto));
        return teamMapper.toDto(footballTeam);
    }

    @GetMapping("/{id}")
    public FootballTeamResponseDto findById(@PathVariable Long id) {
        FootballTeam footballTeam = footballTeamService.getById(id);
        return teamMapper.toDto(footballTeam);
    }

    @PutMapping("/{id}")
    public FootballTeamResponseDto update(@PathVariable Long id,
                                          @RequestBody FootballTeamRequestDto dto) {
        FootballTeam footballTeam = teamMapper.toModel(dto);
        footballTeam.setId(id);
        footballTeamService.update(footballTeam);
        return teamMapper.toDto(footballTeam);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballTeamService.delete(id);
    }
}
