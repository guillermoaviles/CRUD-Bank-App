package com.ironhack.crudbankapp.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.crudbankapp.model.CheckingAccount;
import com.ironhack.crudbankapp.repository.CheckingAccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CheckingAccountControllerTest {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    CheckingAccount checkingAccount1;
    CheckingAccount checkingAccount2;
    CheckingAccount checkingAccount3;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        checkingAccount1 = new CheckingAccount("Guillermo Aviles");
        checkingAccount2 = new CheckingAccount("Sofia Mendez");
        checkingAccount3 = new CheckingAccount("Bayi Aviles");
    }

    @AfterEach
    void tearDown() {
        checkingAccountRepository.deleteById(1);
        checkingAccountRepository.deleteById(2);
        checkingAccountRepository.deleteById(3);
    }

    @Test
    void saveCheckingAccount_validBody_checkingAccountSaved() throws Exception {
        String body = objectMapper.writeValueAsString(checkingAccount1);

        mockMvc.perform(post("/api/accounts/checking").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(checkingAccountRepository.findAll().toString().contains("Guillermo Aviles"));
    }

    @Test
    void updateCheckingAccount_validBody_checkingAccountUpdated() {

    }

    @Test
    void deleteCheckingAccount() {
    }
}