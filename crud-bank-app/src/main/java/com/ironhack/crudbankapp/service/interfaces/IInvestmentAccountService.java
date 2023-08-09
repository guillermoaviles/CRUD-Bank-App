package com.ironhack.crudbankapp.service.interfaces;

import com.ironhack.crudbankapp.model.InvestmentAccount;

public interface IInvestmentAccountService {

    InvestmentAccount getInvestmentAccountByAccountNumber(Integer accountNumber);

    void updateInvestmentAccount(InvestmentAccount investmentAccount, Integer accountNumber);

    void deleteInvestmentAccount(Integer accountNumber);
}
