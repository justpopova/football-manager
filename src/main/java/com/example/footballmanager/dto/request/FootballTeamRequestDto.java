package com.example.footballmanager.dto.request;

import java.util.List;

public class FootballTeamRequestDto {
    private String name;
    private List<Long> playersIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPlayersIds() {
        return playersIds;
    }

    public void setPlayersIds(List<Long> playersIds) {
        this.playersIds = playersIds;
    }
}
