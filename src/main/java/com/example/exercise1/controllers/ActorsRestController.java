package com.example.exercise1.controllers;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.service.ActorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsRestController {
    private ActorsService actorsService;

    public ActorsRestController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping("/actors/all")
    public List<Actor> getAllActors() {
        return actorsService.getAllActors();
    }

    @PostMapping("/actors/{movieName}")
    public List<Actor> getAllActorsByMovieName(@PathVariable String movieName) {
        return actorsService.getAllActorsByMovieName(movieName);
    }

}
