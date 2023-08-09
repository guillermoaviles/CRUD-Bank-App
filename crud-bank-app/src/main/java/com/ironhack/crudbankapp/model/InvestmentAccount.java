package com.ironhack.crudbankapp.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class InvestmentAccount extends Account{
    private Double apy;
    @Embedded
    private List<Deposit> deposits;
    public InvestmentAccount() {
        super();
    }

    public InvestmentAccount(String owner, Double apy) {
        super(owner);
        this.apy = apy;
    }

    public Double getAPY() {
        return apy;
    }

    public void setAPY(Double apy) {
        this.apy = apy;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
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
