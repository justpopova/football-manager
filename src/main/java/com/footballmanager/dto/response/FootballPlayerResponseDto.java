package com.footballmanager.dto.response;

import java.time.LocalDate;

public class FootballPlayerResponseDto {
    private Long id;
    private String name;
    private LocalDate age;
    private LocalDate yearsExperience;
    private Long footballTeamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public LocalDate getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(LocalDate yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Long getFootballTeamId() {
        return footballTeamId;
    }

    public void setFootballTeamId(Long footballTeamId) {
        this.footballTeamId = footballTeamId;
    }
}
