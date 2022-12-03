package com.example.footballmanager.dto.response;

public class FootballPlayerResponseDto {
    private Long id;
    private String name;
    private int age;
    private double yearsExperience;
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
