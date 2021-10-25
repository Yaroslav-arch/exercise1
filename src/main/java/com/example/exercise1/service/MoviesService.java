package com.example.exercise1.service;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.entities.Genre;
import com.example.exercise1.entities.Movie;
import com.example.exercise1.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
    private final MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Movie getMovieByName(String name){
        return moviesRepository.getMovieByName(name);
    }

    public List<Movie> getAllMoviesByActor(Actor actor) {
        return moviesRepository.getAllMoviesByActors(actor);
    }

    public List<Movie> getAllMoviesByGenre(Genre genre) {
        return moviesRepository.getAllMoviesByGenres(genre);
    }
}
