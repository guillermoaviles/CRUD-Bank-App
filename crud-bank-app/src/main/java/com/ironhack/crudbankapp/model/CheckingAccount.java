package com.ironhack.crudbankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class CheckingAccount extends Account {

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(String owner) {
        super(owner);
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
