package com.ironhack.crudbankapp.service.interfaces;

import com.ironhack.crudbankapp.model.CheckingAccount;

public interface ICheckingAccountService {
    CheckingAccount getCheckingAccountByAccountNumber(Integer accountNumber);

    void updateCheckingAccount(CheckingAccount checkingAccount, Integer accountNumber);

    void deleteCheckingAccount(Integer accountNumber);

    void transfer(Integer fromId, Integer destinationId, Double amount);
}
