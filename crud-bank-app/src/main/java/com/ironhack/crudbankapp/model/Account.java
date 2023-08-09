package com.ironhack.crudbankapp.model;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="accountNumber")
public abstract class Account {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGen")
    private Integer accountNumber;
    private String owner;
    private Double balance;

    public Account() {
        this.balance = 0.0;
    }

    public Account(String owner) {
        this.owner = owner;
        this.balance = 0.0;
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

    public void setBalance(Double balance) {
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
