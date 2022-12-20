package com.footballmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "football_players")
public class FootballPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Column(name = "years_experience")
    private int yearsExperience;
    @ManyToOne
    @JoinColumn(name = "football_team")
    private FootballTeam footballTeam;

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

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public FootballTeam getFootballTeam() {
        return footballTeam;
    }

    public void setFootballTeam(FootballTeam footballTeam) {
        this.footballTeam = footballTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FootballPlayer)){
            return false;
        }
        FootballPlayer that = (FootballPlayer) o;
        return getAge() == that.getAge() && Double.compare(that.getYearsExperience(),
                getYearsExperience()) == 0 && Objects.equals(getId(),
                that.getId()) && Objects.equals(getName(),
                that.getName()) && Objects.equals(getFootballTeam(),
                that.getFootballTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getYearsExperience(), getFootballTeam());
    }

    @Override
    public String toString() {
        return "FootballPlayer{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age
                + ", yearsExperience=" + yearsExperience + '}';
    }
}
