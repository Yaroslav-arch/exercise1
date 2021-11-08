package com.example.exercise1.controllers;

import com.example.exercise1.entities.dto.ActorDTO;
import com.example.exercise1.services.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorRestController {

    private final MainService mainService;

    @Inject
    public ActorRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/all")
    public List<ActorDTO> getAllActors() {
        return mainService.getAllActors();
    }

    @GetMapping("/{movieName}")
    public List<ActorDTO> getAllActorsByMovieName(@PathVariable String movieName) {
        return mainService.getAllActorsByMovieName(movieName);
    }

}
