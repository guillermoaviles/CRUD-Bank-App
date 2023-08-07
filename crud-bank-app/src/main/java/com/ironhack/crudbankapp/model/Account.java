package com.ironhack.crudbankapp.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Account {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGen")
    private Integer accountNumber;
    private String owner;
    private double balance;

    public Account() {
    }

    public Account(String owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
