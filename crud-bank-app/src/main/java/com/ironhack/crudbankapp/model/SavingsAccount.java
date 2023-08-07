package com.ironhack.crudbankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="id")
public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(String owner, Double interestRate) {
        super(owner);
        this.interestRate = interestRate;
    }

    public void transferIn(Double amount) {
        setBalance(getBalance() + amount);
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
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
