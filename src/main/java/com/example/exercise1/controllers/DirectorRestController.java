package com.example.exercise1.controllers;

import com.example.exercise1.entities.dto.DirectorDTO;
import com.example.exercise1.services.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorRestController {

    private final MainService mainService;

    @Inject
    public DirectorRestController(MainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping("/all")
    public List<DirectorDTO> getAllDirectors() {
        return mainService.getAllDirectors();
    }
}
