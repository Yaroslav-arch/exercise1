package com.example.exercise1.controllers;

import com.example.exercise1.entities.Movie;
import com.example.exercise1.service.ActorService;
import com.example.exercise1.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private final MovieService movieService;
    private final ActorService actorService;

    public MovieRestController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieName}")
    public Movie getMovieByName(@PathVariable String movieName) {
        return movieService.getMovieByName(movieName);
    }

    @PostMapping("/{actorName}")
    public List<Movie> getAllMoviesByActor(@PathVariable String actorName) {
        return movieService.getAllMoviesByActor(actorService.getActorByName(actorName));
    }
}
