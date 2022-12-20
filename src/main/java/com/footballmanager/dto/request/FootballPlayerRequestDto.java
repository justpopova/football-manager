package com.footballmanager.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FootballPlayerRequestDto {
    @NotNull
    private String name;
    @Min(18)
    private int age;
    @Min(1)
    private int yearsExperience;
    private Long footballTeamId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Long getFootballTeamId() {
        return footballTeamId;
    }

    public void setFootballTeamId(Long footballTeamId) {
        this.footballTeamId = footballTeamId;
    }
}
