package com.ironhack.crudbankapp.controller.interfaces;

import com.ironhack.crudbankapp.model.InvestmentAccount;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IInvestmentAccountController {
    List<InvestmentAccount> getAllInvestmentAccounts();
    InvestmentAccount getInvestmentAccountByAccountNumber(@PathVariable Integer accountNumber);
    List<InvestmentAccount> getAllInvestmentAccountsByOwner(@PathVariable String owner);
    void saveAccount(@RequestBody @Valid InvestmentAccount investmentAccount);
    void updateAccount(@RequestBody @Valid InvestmentAccount investmentAccount, @PathVariable Integer accountNumber);
    void deleteAccount(@PathVariable Integer accountNumber);
}
