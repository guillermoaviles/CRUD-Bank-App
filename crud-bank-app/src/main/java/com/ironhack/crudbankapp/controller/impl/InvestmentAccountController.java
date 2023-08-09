package com.ironhack.crudbankapp.controller.impl;

import com.ironhack.crudbankapp.controller.interfaces.IInvestmentAccountController;
import com.ironhack.crudbankapp.model.InvestmentAccount;
import com.ironhack.crudbankapp.repository.InvestmentAccountRepository;
import com.ironhack.crudbankapp.service.impl.InvestmentAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestmentAccountController implements IInvestmentAccountController {

    @Autowired
    InvestmentAccountRepository investmentAccountRepository;

    @Autowired
    InvestmentAccountService investmentAccountService;

    // **************************************************  GET  *******************************************************
    @GetMapping("/accounts/savings")
    @ResponseStatus(HttpStatus.OK)
    public List<InvestmentAccount> getAllInvestmentAccounts() {
        return investmentAccountRepository.findAll();
    }

    @GetMapping("/accounts/savings/{accountNumber}")
    public InvestmentAccount getInvestmentAccountByAccountNumber(@PathVariable Integer accountNumber) {
        return investmentAccountService.getInvestmentAccountByAccountNumber(accountNumber);
    }

    @GetMapping("/accounts/savings/owner/{name}")
    public List<InvestmentAccount> getAllInvestmentAccountsByOwner(@PathVariable String owner) {
        return investmentAccountRepository.findAllByOwner(owner);
    }

    // **************************************************  POST  ******************************************************

    @PostMapping("/accounts/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody @Valid InvestmentAccount investmentAccount) {
        investmentAccountRepository.save(investmentAccount);
    }

    //  ****************************************************  PUT  ****************************************************

    @PutMapping("/accounts/savings/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@RequestBody @Valid InvestmentAccount investmentAccount, @PathVariable Integer accountNumber) {
        investmentAccountService.updateInvestmentAccount(investmentAccount, accountNumber);
    }

    //  **************************************************  DELETE  ***************************************************

    @DeleteMapping("/accounts/savings/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Integer accountNumber) {
        investmentAccountService.deleteInvestmentAccount(accountNumber);
    }

}
