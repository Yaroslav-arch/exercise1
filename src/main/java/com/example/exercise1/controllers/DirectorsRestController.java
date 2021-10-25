package com.example.exercise1.controllers;

import com.example.exercise1.entities.Director;
import com.example.exercise1.service.DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorsRestController {

    private DirectorsService directorsService;

    @Autowired
    public DirectorsRestController(DirectorsService directorsService) {
        this.directorsService = directorsService;
    }


    @GetMapping("/directors/*")
    public List<Director> getAllDirectors() {
        return directorsService.getAllDirectors();
    }
}
