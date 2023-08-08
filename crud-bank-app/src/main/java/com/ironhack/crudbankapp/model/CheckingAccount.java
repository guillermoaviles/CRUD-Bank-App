package com.ironhack.crudbankapp.model;

import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import com.ironhack.crudbankapp.repository.SavingsAccountRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Entity
@PrimaryKeyJoinColumn(name="accountNumber")
public class CheckingAccount extends Account {

    public CheckingAccount() {
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
