package com.example.exercise1.controllers;

import com.example.exercise1.entities.Genre;
import com.example.exercise1.service.GenresService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresRestController {
    private final GenresService genresService;

    public GenresRestController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping("/*")
    public List<Genre> getAllGenres() {
        return genresService.getAllGenres();
    }
}
