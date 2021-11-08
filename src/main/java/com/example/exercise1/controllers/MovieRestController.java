package com.example.exercise1.controllers;

import com.example.exercise1.entities.dto.MovieDTO;
import com.example.exercise1.exceptions.MovieRestControllerNullException;
import com.example.exercise1.services.MainService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private final MainService mainService;

    @Inject
    public MovieRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/all")
    public List<MovieDTO> getAllMovies() {
        return mainService.getAllMovies();
    }

    @GetMapping("/movie/{movieName}")
    public MovieDTO getMovieByName(@PathVariable String movieName) throws MovieRestControllerNullException {
        if (!Objects.equals(movieName, "null")) {
            return mainService.getMovieByName(movieName);
        } else throw new MovieRestControllerNullException("Null can't be the name of the movie");
    }

    @GetMapping("/actor")
    public List<MovieDTO> getAllMoviesByActorsName(@RequestParam String actorName) {
        return mainService.getAllMoviesByActorsName(actorName);
    }

    @GetMapping("/genre/{genreName}")
    public List<MovieDTO> getMoviesByGenre(@PathVariable String genreName) {
        return mainService.getAllMoviesByGenreName(genreName);
    }
}
