package com.footballmanager.service.impl;

import com.footballmanager.model.FootballPlayer;
import com.footballmanager.model.bankaccount.BankAccount;
import com.footballmanager.service.BankAccountService;
import com.footballmanager.service.FootballManagerService;
import com.footballmanager.service.FootballPlayerService;
import com.footballmanager.service.FootballTeamService;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class FootballManagerServiceImpl implements FootballManagerService {

    private static final int YEAR_IN_MONTHS = 12;
    private static final int BASE_PRICE = 100000;
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
    public FootballPlayer transferPlayerToAnotherTeam(Long playerId, Long transferToTeamId) {
        FootballPlayer player = playerService.getById(playerId);
        if (player.getFootballTeam() == null) {
            player.setFootballTeam(footballTeamService.getById(transferToTeamId));
            playerService.save(player);
            return player;
        }

        BankAccount sender = footballTeamService.getById(transferToTeamId).getBankAccount();
        BankAccount receiver = player.getFootballTeam().getBankAccount();

        bankAccountService.transfer(sender, receiver,
                BigDecimal.valueOf(countTransferExpenses(player)));

        player.setFootballTeam(footballTeamService.getById(transferToTeamId));
        playerService.save(player);
        return player;
    }

    private double countTransferExpenses(FootballPlayer player) {
        double transferCost = (player.getYearsExperience() * YEAR_IN_MONTHS)
                * BASE_PRICE / player.getAge();
        double commissionPrice = transferCost * player.getFootballTeam().getCommission();
        return transferCost + commissionPrice;
    }
}
