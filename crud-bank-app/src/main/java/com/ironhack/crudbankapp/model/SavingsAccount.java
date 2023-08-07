package com.ironhack.crudbankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="id")
public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(String owner, double interestRate) {
        super(owner);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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
