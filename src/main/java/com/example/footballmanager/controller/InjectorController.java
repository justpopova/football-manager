package com.example.footballmanager.controller;

import com.example.footballmanager.model.FootballPlayer;
import com.example.footballmanager.model.FootballTeam;
import com.example.footballmanager.model.bankAccount.BankAccount;
import com.example.footballmanager.service.BankAccountService;
import com.example.footballmanager.service.FootballManagerService;
import com.example.footballmanager.service.FootballPlayerService;
import com.example.footballmanager.service.FootballTeamService;
import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InjectorController {
    private final FootballTeamService footballTeamService;

    private final FootballPlayerService footballPlayerService;

    private final BankAccountService bankAccountService;
    private final FootballManagerService managerService;

    public InjectorController(FootballTeamService footballTeamService,
                              FootballPlayerService footballPlayerService,
                              BankAccountService bankAccountService,
                              FootballManagerService managerService) {
        this.footballTeamService = footballTeamService;
        this.footballPlayerService = footballPlayerService;
        this.bankAccountService = bankAccountService;
        this.managerService = managerService;
    }

    @PostConstruct
    public void inject() {
        BankAccount firstTeamAccount = new BankAccount();
        firstTeamAccount.setAccountNumber("123456");
        firstTeamAccount.setAmount(BigDecimal.valueOf(1500000));
        bankAccountService.save(firstTeamAccount);

        BankAccount secondTeamAccount = new BankAccount();
        secondTeamAccount.setAccountNumber("456789");
        secondTeamAccount.setAmount(BigDecimal.valueOf(2000000));
        bankAccountService.save(secondTeamAccount);

        FootballPlayer player1 = new FootballPlayer();
        player1.setName("Greg");
        player1.setAge(32);
        player1.setYearsExperience(5.2);
        footballPlayerService.save(player1);

        FootballPlayer player2 = new FootballPlayer();
        player2.setName("Bob");
        player2.setAge(29);
        player2.setYearsExperience(4);
        footballPlayerService.save(player2);

        FootballPlayer player3 = new FootballPlayer();
        player3.setName("Edwin");
        player3.setAge(36);
        player3.setYearsExperience(8);
        footballPlayerService.save(player3);

        FootballPlayer player4 = new FootballPlayer();
        player4.setName("Gregory");
        player4.setAge(40);
        player4.setYearsExperience(10);
        footballPlayerService.save(player4);

        FootballTeam team1 = new FootballTeam();
        team1.setName("Blizzard");
        team1.setBankAccount(firstTeamAccount);
        team1.setCommission(0.05);
        team1.setPlayers(List.of(player1, player3));
        footballTeamService.save(team1);

        FootballTeam team2 = new FootballTeam();
        team2.setName("Go Rogers!");
        team2.setBankAccount(secondTeamAccount);
        team2.setCommission(0.07);
        team2.setPlayers(List.of(player2, player4));
        footballTeamService.save(team2);

        player1.setFootballTeam(team1);
        player2.setFootballTeam(team2);
        player3.setFootballTeam(team1);
        player4.setFootballTeam(team2);
        footballPlayerService.save(player1);
        footballPlayerService.save(player2);
        footballPlayerService.save(player3);
        footballPlayerService.save(player4);
    }
}
