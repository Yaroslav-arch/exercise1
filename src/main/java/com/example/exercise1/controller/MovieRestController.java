package com.example.exercise1.controller;

import com.example.exercise1.dto.MovieDTO;
import com.example.exercise1.dto.MovieDtoList;
import com.example.exercise1.exception.MovieRestControllerNullException;
import com.example.exercise1.service.MainService;
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
    public MovieDtoList getAllMovies() {
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

    @PostMapping("/save")
    public void saveMovie(@RequestBody MovieDTO movieDTO) {
        mainService.saveMovie(movieDTO);
    }

    @PostMapping("/all/save")
    public void saveMovies(@RequestBody List<MovieDTO> movies) {
        mainService.saveMovies(movies);
    }
}