package com.example.exercise1.controllers;

import com.example.exercise1.entities.Movie;
import com.example.exercise1.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private final MovieService movieService;

    @Inject
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{movieName}")
    public Movie getMovieByName(@PathVariable String movieName) throws MovieRestControllerNullException {
        if (!Objects.equals(movieName, "null")) {
            return movieService.getMovieByName(movieName);
        } else throw new MovieRestControllerNullException("Null can't be the name of the movie");
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
