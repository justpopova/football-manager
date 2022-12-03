package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.bankAccount.BankAccount;
import com.example.footballmanager.repository.BankAccountRepository;
import com.example.footballmanager.service.BankAccountService;
import java.math.BigDecimal;
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
            throw new RuntimeException("Not enough money!");
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
}
