package com.ironhack.crudbankapp.service.impl;

import com.ironhack.crudbankapp.model.SavingsAccount;
import com.ironhack.crudbankapp.repository.SavingsAccountRepository;
import com.ironhack.crudbankapp.service.interfaces.ISavingsAccountSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SavingsAccountService implements ISavingsAccountSevice {

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Override
    public SavingsAccount getSavingsAccountByAccountNumber(Integer accountNumber) {
        Optional<SavingsAccount> savingsAccountOptional = savingsAccountRepository.findById(accountNumber);
        if (savingsAccountOptional.isEmpty()) return null;
        return savingsAccountOptional.get();
    }

    @Override
    public void updateSavingsAccount(SavingsAccount savingsAccount, Integer accountNumber) {
        Optional<SavingsAccount> savingsAccountOptional = savingsAccountRepository.findById(accountNumber);
        if (savingsAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        savingsAccount.setAccountNumber(accountNumber);
        savingsAccountRepository.save(savingsAccount);
    }

    @Override
    public void deleteSavingsAccount(Integer accountNumber) {
        Optional<SavingsAccount> savingsAccountOptional = savingsAccountRepository.findById(accountNumber);
        if (savingsAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        savingsAccountRepository.deleteById(accountNumber);
    }
}
