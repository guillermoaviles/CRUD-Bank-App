package com.ironhack.crudbankapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class InvestmentAccount extends Account{
    private BigDecimal apy;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deposit> deposits = new ArrayList<>();
    public InvestmentAccount() {
        super();
    }

    public InvestmentAccount(String owner, BigDecimal apy) {
        super(owner);
        this.apy = apy;
    }

    public BigDecimal getAPY() {
        return apy;
    }

    public void setAPY(BigDecimal apy) {
        this.apy = apy;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    @Override
    public BigDecimal getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(BigDecimal balance) {
        super.setBalance(balance);
    }

    public void deposit(BigDecimal amount) {
        LocalDate depositDate = LocalDate.now();
        LocalDate unlockDate = depositDate.plusDays(2); // Adjust unlock period as needed

        Deposit deposit = new Deposit(amount, depositDate, unlockDate, this);
        deposits.add(deposit);
        setBalance(getBalance().add(amount));
    }

    public void withdraw(BigDecimal amount) {
        BigDecimal availableBalance = calculateAvailableBalance();

        if (amount.compareTo(availableBalance) <= 0) {
            setBalance(getBalance().subtract(amount));
            // Logic to liquidate deposits
            liquidateDeposits(amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    private BigDecimal calculateAvailableBalance() {
        LocalDate currentDate = LocalDate.now();
        BigDecimal availableBalance = BigDecimal.valueOf(0);

        for (Deposit deposit : deposits) {
            if (currentDate.isAfter(deposit.getUnlockDate())) {
                availableBalance = availableBalance.add(deposit.getAmount());
            }
        }
        return availableBalance;
    }

    private void liquidateDeposits(BigDecimal withdrawalAmount) {
        LocalDate currentDate = LocalDate.now();

        for (Deposit deposit : deposits) {
            if (currentDate.isAfter(deposit.getUnlockDate())) {
                BigDecimal depositAmount = deposit.getAmount();
                if (withdrawalAmount.compareTo(depositAmount) >= 0) {
                    withdrawalAmount = withdrawalAmount.subtract(depositAmount);
                    deposits.remove(deposit);
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
