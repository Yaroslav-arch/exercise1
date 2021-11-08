package com.example.exercise1.controllers;

import com.example.exercise1.entities.entitiesNeo4j.Genre;
import com.example.exercise1.services.servicesNeo4j.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreRestController {
    private final GenreService genreService;

    @Inject
    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }
}
