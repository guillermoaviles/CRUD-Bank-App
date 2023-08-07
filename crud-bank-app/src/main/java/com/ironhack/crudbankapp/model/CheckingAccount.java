package com.ironhack.crudbankapp.model;

import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@PrimaryKeyJoinColumn(name="id")
public class CheckingAccount extends Account {


    public CheckingAccount() {
    }

    public CheckingAccount(String owner) {
        super(owner);

    }

    public void transferIn(Double amount) {
        setBalance(getBalance() + amount);
    }

    public void transferOut(Double amount, Account account) {
        setBalance(getBalance() - amount);
        account.transferIn(amount);
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
