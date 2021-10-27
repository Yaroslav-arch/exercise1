package com.example.exercise1.controllers;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.service.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorRestController {
    private ActorService actorService;

    @Inject
    public ActorRestController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/all")
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{movieName}")
    public List<Actor> getAllActorsByMovieName(@PathVariable String movieName) {
        return actorService.getAllActorsByMovieName(movieName);
    }

}
