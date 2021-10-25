package com.example.exercise1.controllers;

import com.example.exercise1.entities.User;
import com.example.exercise1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersRestController {
    private UsersService usersService;

    @Autowired
    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/users/*")
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }
}
