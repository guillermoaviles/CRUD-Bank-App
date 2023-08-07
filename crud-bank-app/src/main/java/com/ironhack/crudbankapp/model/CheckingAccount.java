package com.ironhack.crudbankapp.model;

import jakarta.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="id")
public class CheckingAccount extends Account {


    public CheckingAccount() {
    }

    public CheckingAccount(String owner) {
        super(owner);

    }

    public void processPayment(double paymentAmount) {

    }

    public void processDebit(double purchaseAmount) {

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
