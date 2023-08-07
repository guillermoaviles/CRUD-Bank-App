package com.ironhack.crudbankapp.controller.impl;

import com.ironhack.crudbankapp.controller.interfaces.ISavingsAccountController;
import com.ironhack.crudbankapp.model.SavingsAccount;
import com.ironhack.crudbankapp.repository.SavingsAccountRepository;
import com.ironhack.crudbankapp.service.impl.SavingsAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SavingsAccountController implements ISavingsAccountController {

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Autowired
    SavingsAccountService savingsAccountService;

    // **************************************************  GET  *******************************************************
    @GetMapping("/accounts/savings")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccount> getAllSavingsAccounts() {
        return savingsAccountRepository.findAll();
    }

    @GetMapping("/accounts/savings/{accountNumber}")
    public SavingsAccount getSavingsAccountByAccountNumber(@PathVariable Integer accountNumber) {
        return savingsAccountService.getSavingsAccountById(accountNumber);
    }

    @GetMapping("/accounts/savings/owner/{name}")
    public List<SavingsAccount> getAllSavingsAccountsByOwner(@PathVariable String owner) {
        return savingsAccountRepository.findAllByOwner(owner);
    }

    // **************************************************  POST  ******************************************************

    @PostMapping("/accounts/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody @Valid SavingsAccount savingsAccount) {
        savingsAccountRepository.save(savingsAccount);
    }

    //  ****************************************************  PUT  ****************************************************

    @PutMapping("/accounts/savings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@RequestBody @Valid SavingsAccount savingsAccount, @PathVariable Integer accountNumber) {
        savingsAccountService.updateSavingsAccount(savingsAccount, accountNumber);
    }

    //  **************************************************  DELETE  ***************************************************

    @DeleteMapping("/accounts/savings/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Integer accountNumber) {
        savingsAccountService.deleteSavingsAccount(accountNumber);
    }

}
