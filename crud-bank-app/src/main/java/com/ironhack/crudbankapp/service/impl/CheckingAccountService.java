package com.ironhack.crudbankapp.service.impl;

import com.ironhack.crudbankapp.controller.impl.CheckingAccountController;
import com.ironhack.crudbankapp.model.CheckingAccount;
import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import com.ironhack.crudbankapp.service.interfaces.ICheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class CheckingAccountService implements ICheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Override
    public CheckingAccount getCheckingAccountByAccountNumber(Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) return null;
        return checkingAccountOptional.get();
    }

    @Override
    public void updateCheckingAccount(CheckingAccount checkingAccount, Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        checkingAccount.setAccountNumber(accountNumber);
        checkingAccountRepository.save(checkingAccount);
    }

    @Override
    public void deleteCheckingAccount(Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        checkingAccountRepository.deleteById(accountNumber);
    }
}
