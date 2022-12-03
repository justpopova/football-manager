package com.example.footballmanager.dto.request;

import java.util.List;

public class FootballTeamRequestDto {
    private String name;
    private List<Long> playersIds;
    private Long bankAccountId;
    private double commission;

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

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
