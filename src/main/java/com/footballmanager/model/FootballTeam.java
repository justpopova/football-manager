package com.footballmanager.model;

import com.footballmanager.model.bankaccount.BankAccount;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "football_teams")
public class FootballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "footballTeam")
    private List<FootballPlayer> players;
    @OneToOne
    @JoinColumn(name = "bank_account")
    private BankAccount bankAccount;
    private BigDecimal commission;

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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    @PreRemove
    public void clearUpPlayers() {
        players.forEach(footballPlayer -> footballPlayer.setFootballTeam(null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballTeam)) return false;
        FootballTeam that = (FootballTeam) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getPlayers(), that.getPlayers())
                && Objects.equals(getBankAccount(), that.getBankAccount())
                && Objects.equals(getCommission(), that.getCommission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPlayers(), getBankAccount(), getCommission());
    }

    @Override
    public String toString() {
        return "FootballTeam{" + "id=" + id
                + ", name='" + name
                + '\'' + ", players=" + players + '}';
    }
}
