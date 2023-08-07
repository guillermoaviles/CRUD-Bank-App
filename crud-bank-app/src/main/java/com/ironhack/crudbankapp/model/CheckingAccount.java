package com.ironhack.crudbankapp.model;

import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="id")
public class CheckingAccount extends Account {


    public CheckingAccount() {
    }

    public CheckingAccount(String owner) {
        super(owner);

    }

    public void transferIn(double amount) {
        setBalance(getBalance() + amount);
    }

    public void transferOut(double amount, CheckingAccount checkingAccount) {
        setBalance(getBalance() - amount);
        checkingAccount.transferIn(amount);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
