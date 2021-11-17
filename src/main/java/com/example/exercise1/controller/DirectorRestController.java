package com.example.exercise1.controller;

import com.example.exercise1.dto.DirectorDTO;
import com.example.exercise1.service.MainService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public void saveDirector(@RequestBody DirectorDTO directorDTO) {
        mainService.saveDirector(directorDTO);
    }
}
