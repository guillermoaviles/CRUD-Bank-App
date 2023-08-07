package com.ironhack.crudbankapp.service.interfaces;

import com.ironhack.crudbankapp.model.SavingsAccount;

public interface ISavingsAccountSevice {

    SavingsAccount getSavingsAccountByAccountNumber(Integer accountNumber);

    void updateSavingsAccount(SavingsAccount savingsAccount, Integer accountNumber);

    void deleteSavingsAccount(Integer accountNumber);
}
