package com.example.footballmanager.dto.request;

public class FootballPlayerRequestDto {
    private String name;
    private int age;
    private double yearsExperience;
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

    public double getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(double yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Long getFootballTeamId() {
        return footballTeamId;
    }

    public void setFootballTeamId(Long footballTeamId) {
        this.footballTeamId = footballTeamId;
    }
}
