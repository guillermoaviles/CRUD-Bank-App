package com.ironhack.crudbankapp.service.impl;

import com.ironhack.crudbankapp.controller.impl.CheckingAccountController;
import com.ironhack.crudbankapp.model.Account;
import com.ironhack.crudbankapp.model.CheckingAccount;
import com.ironhack.crudbankapp.model.SavingsAccount;
import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import com.ironhack.crudbankapp.repository.SavingsAccountRepository;
import com.ironhack.crudbankapp.service.interfaces.ICheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class CheckingAccountService implements ICheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Override
    public CheckingAccount getCheckingAccountByAccountNumber(Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) return null;
        return checkingAccountOptional.get();
    }

    @Override
    public void updateCheckingAccount(CheckingAccount checkingAccount, Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account #" + accountNumber + " not found");
        checkingAccount.setAccountNumber(accountNumber);
        checkingAccountRepository.save(checkingAccount);
    }

    @Override
    public void transfer(Integer fromId, Integer destinationId, Double amount) {
        Optional<CheckingAccount> fromCheckingAccountOptional = checkingAccountRepository.findById(fromId);
        if (fromCheckingAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account #" + fromId + " not found");
        CheckingAccount fromCheckingAccount = fromCheckingAccountOptional.get();

        // Account destinationAccount;
        Optional<CheckingAccount> destinationCheckingAccountOptional = checkingAccountRepository.findById(destinationId);
        Optional<SavingsAccount> destinationSavingsAccountOptional = savingsAccountRepository.findById(destinationId);
        if (destinationCheckingAccountOptional.isPresent()) {
            // destinationAccount = destinationCheckingAccountOptional.get();
            fromCheckingAccount.transferOutChecking(amount, destinationCheckingAccountOptional.get());
            checkingAccountRepository.save(fromCheckingAccount);
        } else if (destinationSavingsAccountOptional.isPresent()) {
            // destinationAccount = destinationSavingsAccountOptional.get();
            fromCheckingAccount.transferOutSavings(amount, destinationSavingsAccountOptional.get());
            checkingAccountRepository.save(fromCheckingAccount);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account #" + destinationId + " not found");

        // transferOut needs to return updated destination account

    }

    @Override
    public void deleteCheckingAccount(Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        checkingAccountRepository.deleteById(accountNumber);
    }
}
