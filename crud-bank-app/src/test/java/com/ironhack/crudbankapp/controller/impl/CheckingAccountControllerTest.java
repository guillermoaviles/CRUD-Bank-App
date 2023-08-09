package com.ironhack.crudbankapp.controller.impl;

import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckingAccountControllerTest {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    WebApplicationContext webApplicationContext;


    @Test
    void saveCheckingAccount() {
    }

    @Test
    void updateCheckingAccount() {
    }

    @Test
    void deleteCheckingAccount() {
    }
}