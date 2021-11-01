package com.example.exercise1.controllers;

import com.example.exercise1.entities.Movie;
import com.example.exercise1.services.GenreService;
import com.example.exercise1.services.MovieService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private final MovieService movieService;
    private final GenreService genreService;

    @Inject
    public MovieRestController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{movieName}")
    public Movie getMovieByName(@PathVariable String movieName) {
        return movieService.getMovieByName(movieName);
    }

    @GetMapping("/actor")
    public List<Movie> getAllMoviesByActorsName(@RequestParam String actorName) {
        return movieService.getAllMoviesByActorsName(actorName);
    }

    @GetMapping("/genre/{genreName}")
    public List<Movie> getMoviesByGenre(@PathVariable String genreName) {
        return movieService.getAllMoviesByGenreName(genreName);
    }
}
