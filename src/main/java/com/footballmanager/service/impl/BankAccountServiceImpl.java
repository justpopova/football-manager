package com.footballmanager.service.impl;

import com.footballmanager.exception.FinancialTransactionException;
import com.footballmanager.model.bankaccount.BankAccount;
import com.footballmanager.repository.BankAccountRepository;
import com.footballmanager.service.BankAccountService;
import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankRepository;

    public BankAccountServiceImpl(BankAccountRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    @Transactional
    public void transfer(BankAccount sender, BankAccount receiver, BigDecimal amount) {
        if (sender.getAmount().compareTo(amount) < 0) {
            throw new FinancialTransactionException("Not enough money to make transaction. "
                    + "\nYour balance: " + sender.getAmount() + ". \nPlayer cost: " + amount);
        }

        sender.setAmount(sender.getAmount().subtract(amount));
        receiver.setAmount(receiver.getAmount().add(amount));
        bankRepository.save(sender);
        bankRepository.save(receiver);
    }

    @Override
    public void save(BankAccount bankAccount) {
        bankRepository.save(bankAccount);
    }

    @Override
    public BankAccount getById(Long id) {
        return bankRepository.getReferenceById(id);
    }

    @Override
    public BankAccount createNewBankAccountForTeam() {
        BankAccount account = new BankAccount();
        account.setAccountNumber(String.valueOf(
                ThreadLocalRandom.current().nextInt(100000, 500000)));
        account.setAmount(BigDecimal.valueOf(
                ThreadLocalRandom.current().nextLong(400000, 1000000)));
        bankRepository.save(account);
        return account;
    }
}
