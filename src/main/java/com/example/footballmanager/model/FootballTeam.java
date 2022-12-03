package com.example.footballmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "football_team")
public class FootballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<FootballPlayer> players;

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

    public List<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
