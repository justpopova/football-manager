package com.footballmanager.service;

import com.footballmanager.model.bankaccount.BankAccount;
import java.math.BigDecimal;

public interface BankAccountService {
    void transfer(BankAccount sender, BankAccount receiver, BigDecimal amount);

    void save(BankAccount bankAccount);

    BankAccount getById(Long id);

    BankAccount createNewBankAccountForTeam();
}
