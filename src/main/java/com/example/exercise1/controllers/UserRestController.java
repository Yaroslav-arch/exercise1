package com.example.exercise1.controllers;

import com.example.exercise1.entities.dto.UserDTO;
import com.example.exercise1.services.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final MainService mainService;

    @Inject
    public UserRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return mainService.getAllUsers();
    }
}
