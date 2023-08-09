package com.ironhack.crudbankapp.service.impl;

import com.ironhack.crudbankapp.model.CheckingAccount;
import com.ironhack.crudbankapp.model.InvestmentAccount;
import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import com.ironhack.crudbankapp.repository.InvestmentAccountRepository;
import com.ironhack.crudbankapp.service.interfaces.ICheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CheckingAccountService implements ICheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    InvestmentAccountRepository investmentAccountRepository;

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
        if (amount > fromCheckingAccount.getBalance()) throw new IllegalArgumentException("Not enough funds to cover transfer");

        Optional<CheckingAccount> destinationCheckingAccountOptional = checkingAccountRepository.findById(destinationId);
        Optional<InvestmentAccount> destinationSavingsAccountOptional = investmentAccountRepository.findById(destinationId);
        if (destinationCheckingAccountOptional.isPresent()) {

            // Debit funds from origin checking account
            fromCheckingAccount.setBalance(fromCheckingAccount.getBalance() - amount);
            // Credit funds to destination checking account
            destinationCheckingAccountOptional.get().setBalance(destinationCheckingAccountOptional.get().getBalance() + amount);

            checkingAccountRepository.save(destinationCheckingAccountOptional.get());
            checkingAccountRepository.save(fromCheckingAccount);
        } else if (destinationSavingsAccountOptional.isPresent()) {

            // Debit funds from origin checking account
            fromCheckingAccount.setBalance(fromCheckingAccount.getBalance() - amount);
            // Credit funds to destination checking account
            destinationSavingsAccountOptional.get().setBalance(destinationSavingsAccountOptional.get().getBalance() + amount);

            investmentAccountRepository.save(destinationSavingsAccountOptional.get());
            checkingAccountRepository.save(fromCheckingAccount);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account #" + destinationId + " not found");
    }

    @Override
    public void deleteCheckingAccount(Integer accountNumber) {
        Optional<CheckingAccount> checkingAccountOptional = checkingAccountRepository.findById(accountNumber);
        if (checkingAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        checkingAccountRepository.deleteById(accountNumber);
    }
}
