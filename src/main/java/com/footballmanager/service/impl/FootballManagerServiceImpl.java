package com.footballmanager.service.impl;

import com.footballmanager.model.FootballPlayer;
import com.footballmanager.model.bankaccount.BankAccount;
import com.footballmanager.service.BankAccountService;
import com.footballmanager.service.FootballManagerService;
import com.footballmanager.service.FootballPlayerService;
import com.footballmanager.service.FootballTeamService;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class FootballManagerServiceImpl implements FootballManagerService {
    private static final int YEAR_IN_MONTHS = 12;
    private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(100000.0);
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
        FootballPlayer player = playerService.getAllByIds(playerId);
        if (player.getFootballTeam() == null) {
            player.setFootballTeam(footballTeamService.getById(transferToTeamId));
            playerService.save(player);
            return player;
        }

        BankAccount sender = footballTeamService.getById(transferToTeamId).getBankAccount();
        BankAccount receiver = player.getFootballTeam().getBankAccount();

        bankAccountService.transfer(sender, receiver,countTransferExpenses(player));

        player.setFootballTeam(footballTeamService.getById(transferToTeamId));
        playerService.save(player);
        return player;
    }

    private BigDecimal countTransferExpenses(FootballPlayer player) {
        LocalDate yearsExperience = LocalDate.now().minusYears(player.getYearsExperience().getYear());

        int experienceInMonths = (yearsExperience.getYear() * YEAR_IN_MONTHS) + yearsExperience.getMonthValue();

        LocalDate playerAge = LocalDate.now().minusYears(player.getAge().getYear());
        BigDecimal transferCost = BASE_PRICE.multiply(BigDecimal.valueOf(experienceInMonths)).divide(BigDecimal.valueOf(playerAge.getYear()));
        BigDecimal commissionPrice = transferCost.multiply(player.getFootballTeam().getCommission());
        return transferCost.add(commissionPrice);
    }
}
