package com.ironhack.crudbankapp.controller.interfaces;

import com.ironhack.crudbankapp.model.SavingsAccount;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ISavingsAccountController {
    List<SavingsAccount> getAllSavingsAccounts();
    SavingsAccount getSavingsAccountByAccountNumber(@PathVariable Integer accountNumber);
    List<SavingsAccount> getAllSavingsAccountsByOwner(@PathVariable String owner);
    void saveAccount(@RequestBody @Valid SavingsAccount savingsAccount);
    void updateAccount(@RequestBody @Valid SavingsAccount savingsAccount, @PathVariable Integer accountNumber);
    void deleteAccount(@PathVariable Integer accountNumber);
}
