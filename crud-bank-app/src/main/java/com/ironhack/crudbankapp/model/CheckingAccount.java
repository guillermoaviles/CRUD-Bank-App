package com.ironhack.crudbankapp.model;

import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import com.ironhack.crudbankapp.repository.SavingsAccountRepository;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@PrimaryKeyJoinColumn(name="id")
public class CheckingAccount extends Account {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;


    public CheckingAccount() {
    }

    public CheckingAccount(String owner) {
        super(owner);

    }

    public void transferIn(Double amount) {
        setBalance(getBalance() + amount);
    }

    public void transferOutChecking(Double amount, CheckingAccount checkingAccount) {
        setBalance(getBalance() - amount);
        checkingAccount.transferIn(amount);
        checkingAccountRepository.save(checkingAccount);
    }

    public void transferOutSavings(Double amount, SavingsAccount savingsAccount) {
        setBalance(getBalance() - amount);
        savingsAccount.transferIn(amount);
        savingsAccountRepository.save(savingsAccount);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }


    @Override
    public void setBalance(Double balance) {
        super.setBalance(balance);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
