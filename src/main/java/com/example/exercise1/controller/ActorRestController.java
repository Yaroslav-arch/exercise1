package com.example.exercise1.controller;

import com.example.exercise1.dto.ActorDTO;
import com.example.exercise1.service.MainService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save")
    public void saveActor(@RequestBody ActorDTO actorDTO){
        mainService.saveActor(actorDTO);
    }

}
