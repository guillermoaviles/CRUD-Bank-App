package com.ironhack.crudbankapp.controller.interfaces;

import com.ironhack.crudbankapp.dtos.AmountDTO;
import com.ironhack.crudbankapp.model.CheckingAccount;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICheckingAccountController {
    List<CheckingAccount> getAllCheckingAccounts();
    CheckingAccount getCheckingAccountByAccountNumber(@PathVariable Integer accountNumber);
    List<CheckingAccount> getAllCheckingAccountsByOwner(@PathVariable String owner);
    void saveCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount);
    void updateCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount, @PathVariable Integer accountNumber);
    void transfer(@PathVariable Integer fromId, @PathVariable Integer destinationId, @PathVariable AmountDTO amountDTO);
    void deleteCheckingAccount(@PathVariable Integer accountNumber);
}
