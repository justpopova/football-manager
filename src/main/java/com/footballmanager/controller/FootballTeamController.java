package com.footballmanager.controller;

import com.footballmanager.dto.request.FootballTeamRequestDto;
import com.footballmanager.dto.response.FootballTeamResponseDto;
import com.footballmanager.mapper.FootballTeamDtoMapper;
import com.footballmanager.model.FootballTeam;
import com.footballmanager.service.FootballTeamService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-teams")
public class FootballTeamController {
    private final FootballTeamDtoMapper teamDtoMapper;
    private final FootballTeamService footballTeamService;

    public FootballTeamController(FootballTeamDtoMapper teamDtoMapper,
                                  FootballTeamService footballTeamService) {
        this.teamDtoMapper = teamDtoMapper;
        this.footballTeamService = footballTeamService;
    }

    @PostMapping
    public FootballTeamResponseDto create(@RequestBody @Valid FootballTeamRequestDto dto) {
        FootballTeam footballTeam = footballTeamService.save(teamDtoMapper.mapToModel(dto));
        return teamDtoMapper.mapToDto(footballTeam);
    }

    @GetMapping("/{id}")
    public FootballTeamResponseDto findById(@PathVariable Long id) {
        FootballTeam footballTeam = footballTeamService.getById(id);
        return teamDtoMapper.mapToDto(footballTeam);
    }

    @PutMapping("/{id}")
    public FootballTeamResponseDto update(@PathVariable Long id,
                                          @RequestBody FootballTeamRequestDto dto) {
        FootballTeam footballTeam = footballTeamService.update(id, dto);
        return teamDtoMapper.mapToDto(footballTeam);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        footballTeamService.delete(id);
    }

    @GetMapping
    public List<FootballTeamResponseDto> getAll() {
        return footballTeamService.getAll().stream()
                .map(teamDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
