package com.example.exercise1.controller;

import com.example.exercise1.dto.GenreDTO;
import com.example.exercise1.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreRestController {
    private final MainService mainService;

    @Inject
    public GenreRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/all")
    public List<GenreDTO> getAllGenres() {
        return mainService.getAllGenres();
    }

    @GetMapping("/all/{genreName}")
    public GenreDTO getMovieByName(@PathVariable String genreName) {
        return mainService.getGenreByName(genreName);

    }
}