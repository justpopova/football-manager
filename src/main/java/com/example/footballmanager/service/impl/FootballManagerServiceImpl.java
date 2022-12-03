package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.model.bankAccount.BankAccount;
import com.example.footballmanager.service.BankAccountService;
import com.example.footballmanager.service.FootballManagerService;
import com.example.footballmanager.service.FootballPlayerService;
import com.example.footballmanager.service.FootballTeamService;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class FootballManagerServiceImpl implements FootballManagerService {

    private final BankAccountService bankAccountService;
    private final FootballTeamService footballTeamService;
    private final FootballPlayerService playerService;

    public FootballManagerServiceImpl(BankAccountService bankAccountService,
                                      FootballTeamService footballTeamService,
                                      FootballPlayerService playerService) {
        this.bankAccountService = bankAccountService;
        this.footballTeamService = footballTeamService;
        this.playerService = playerService;
    }

    @Override
    public void transferPlayerToAnotherTeam(FootballPlayer player, Long transferToTeamId) {
        BankAccount sender = footballTeamService.getById(transferToTeamId).getBankAccount();
        BankAccount receiver = player.getFootballTeam().getBankAccount();

        bankAccountService.transfer(sender, receiver,
                BigDecimal.valueOf(countTransferExpenses(player)));

        player.setFootballTeam(footballTeamService.getById(transferToTeamId));
        playerService.save(player);
    }

    private double countTransferExpenses(FootballPlayer player) {
        double transferCost = (player.getYearsExperience() * 12) * 100000 / player.getAge();
        double commissionPrice = transferCost * player.getFootballTeam().getCommission();
        return transferCost + commissionPrice;
    }
}
