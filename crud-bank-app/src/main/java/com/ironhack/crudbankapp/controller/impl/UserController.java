package com.ironhack.crudbankapp.controller.impl;

import com.ironhack.crudbankapp.model.CheckingAccount;
import com.ironhack.crudbankapp.model.User;
import com.ironhack.crudbankapp.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * User service for accessing user data
     */
    @Autowired
    private UserServiceInterface userService;

    /**
     * Get a list of all users
     *
     * @return list of all users
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Save a new user
     *
     * @param user the user to be saved
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCheckingAccountToUser(@RequestBody CheckingAccount checkingAccount, @PathVariable Integer id) {
        userService.addCheckingAccountToUser(checkingAccount, id);
    }

}
