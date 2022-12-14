package com.footballmanager.util;

import com.footballmanager.model.FootballPlayer;
import com.footballmanager.model.FootballTeam;
import com.footballmanager.service.FootballPlayerService;
import com.footballmanager.service.FootballTeamService;
import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TestDataProvider {
    private final FootballTeamService footballTeamService;

    private final FootballPlayerService footballPlayerService;

    public TestDataProvider(FootballTeamService footballTeamService,
                            FootballPlayerService footballPlayerService) {
        this.footballTeamService = footballTeamService;
        this.footballPlayerService = footballPlayerService;
    }

    @PostConstruct
    public void inject() {
        FootballPlayer player1 = new FootballPlayer();
        player1.setName("Greg");
        player1.setAge(LocalDate.of(1990, 9, 10));
        player1.setYearsExperience(LocalDate.of(2020,8,18));
        footballPlayerService.save(player1);

        FootballPlayer player2 = new FootballPlayer();
        player2.setName("Bob");
        player2.setAge(LocalDate.of(1986, 6, 10));
        player2.setYearsExperience(LocalDate.of(2016,2,10));
        footballPlayerService.save(player2);

        FootballPlayer player3 = new FootballPlayer();
        player3.setName("Edwin");
        player3.setAge(LocalDate.of(1992, 1, 8));
        player3.setYearsExperience(LocalDate.of(2019,10,10));
        footballPlayerService.save(player3);

        FootballPlayer player4 = new FootballPlayer();
        player4.setName("Gregory");
        player4.setAge(LocalDate.of(1982, 11, 15));
        player4.setYearsExperience(LocalDate.of(2010,1,21));
        footballPlayerService.save(player4);

        FootballTeam team1 = new FootballTeam();
        team1.setName("Blizzard");
        team1.setCommission(BigDecimal.valueOf(0.05));
        team1.setPlayers(List.of(player1, player3));
        footballTeamService.save(team1);

        FootballTeam team2 = new FootballTeam();
        team2.setName("Go Rogers!");
        team2.setCommission(BigDecimal.valueOf(0.07));
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
