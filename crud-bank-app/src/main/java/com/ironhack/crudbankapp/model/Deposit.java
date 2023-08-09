package com.ironhack.crudbankapp.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer depositId;
    private Date depositDate;
    private Date unlockDate;
    private Double amount;

    public Deposit() {
    }
    public Deposit(Date depositDate, Date unlockDate, Double amount) {
        this.depositDate = depositDate;
        this.unlockDate = unlockDate;
        this.amount = amount;
    }

    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Date getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(Date unlockDate) {
        this.unlockDate = unlockDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Deposit{" +
                "depositId=" + depositId +
                ", depositDate=" + depositDate +
                ", unlockDate=" + unlockDate +
                ", amount=" + amount +
                '}';
    }
}
