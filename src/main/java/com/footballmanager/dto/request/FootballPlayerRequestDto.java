package com.footballmanager.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class FootballPlayerRequestDto {
    @NotNull
    private String name;
    @Min(18)
    private LocalDate age;
    @NotNull
    private LocalDate yearsExperience;
    private Long footballTeamId;

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
