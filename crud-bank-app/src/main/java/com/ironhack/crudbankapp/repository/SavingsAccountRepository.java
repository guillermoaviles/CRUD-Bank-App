package com.ironhack.crudbankapp.repository;

import com.ironhack.crudbankapp.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {
    List<SavingsAccount> findAllByOwner(String owner);

}
