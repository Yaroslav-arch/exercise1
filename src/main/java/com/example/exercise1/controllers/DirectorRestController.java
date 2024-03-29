package com.example.exercise1.controllers;

import com.example.exercise1.entities.Director;
import com.example.exercise1.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorRestController {

    private DirectorService directorService;

    @Autowired
    public DirectorRestController(DirectorService directorService) {
        this.directorService = directorService;
    }


    @GetMapping("/all")
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }
}
