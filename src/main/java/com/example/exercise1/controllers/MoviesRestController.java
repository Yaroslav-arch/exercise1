package com.example.exercise1.controllers;

import com.example.exercise1.entities.Movie;
import com.example.exercise1.service.ActorsService;
import com.example.exercise1.service.MoviesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesRestController {

    private MoviesService moviesService;
    private ActorsService actorsService;

    public MoviesRestController(MoviesService moviesService, ActorsService actorsService) {
        this.moviesService = moviesService;
        this.actorsService = actorsService;
    }

    @GetMapping("/movies/all")
    public List<Movie> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/movies/{movieName}")
    public Movie getMovieByName(@PathVariable String movieName) {
        return moviesService.getMovieByName(movieName);
    }

    @PostMapping("/movies/{actorName}")
    public List<Movie> getAllMoviesByActor(@PathVariable String actorName) {
        return moviesService.getAllMoviesByActor(actorsService.getActorByName(actorName));
    }
}
