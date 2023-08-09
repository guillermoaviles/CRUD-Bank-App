package com.ironhack.crudbankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class InvestmentAccount extends Account{
    private Double interestRate;

    public InvestmentAccount() {
        super();
    }

    public InvestmentAccount(String owner, Double interestRate) {
        super(owner);
        this.interestRate = interestRate;
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
