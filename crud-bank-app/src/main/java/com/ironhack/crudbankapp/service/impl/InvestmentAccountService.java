package com.ironhack.crudbankapp.service.impl;

import com.ironhack.crudbankapp.model.InvestmentAccount;
import com.ironhack.crudbankapp.repository.InvestmentAccountRepository;
import com.ironhack.crudbankapp.service.interfaces.IInvestmentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class InvestmentAccountService implements IInvestmentAccountService {

    @Autowired
    InvestmentAccountRepository investmentAccountRepository;

    @Override
    public InvestmentAccount getInvestmentAccountByAccountNumber(Integer accountNumber) {
        Optional<InvestmentAccount> savingsAccountOptional = investmentAccountRepository.findById(accountNumber);
        if (savingsAccountOptional.isEmpty()) return null;
        return savingsAccountOptional.get();
    }

    @Override
    public void updateInvestmentAccount(InvestmentAccount investmentAccount, Integer accountNumber) {
        Optional<InvestmentAccount> savingsAccountOptional = investmentAccountRepository.findById(accountNumber);
        if (savingsAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        investmentAccount.setAccountNumber(accountNumber);
        investmentAccountRepository.save(investmentAccount);
    }

    @Override
    public void deleteInvestmentAccount(Integer accountNumber) {
        Optional<InvestmentAccount> savingsAccountOptional = investmentAccountRepository.findById(accountNumber);
        if (savingsAccountOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        investmentAccountRepository.deleteById(accountNumber);
    }
}
