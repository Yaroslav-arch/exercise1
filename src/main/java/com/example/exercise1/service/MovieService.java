package com.example.exercise1.service;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.entities.Genre;
import com.example.exercise1.entities.Movie;
import com.example.exercise1.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }

    public List<Movie> getAllMoviesByActor(Actor actor) {
        return movieRepository.getAllMoviesByActors(actor);
    }

    public List<Movie> getAllMoviesByGenre(Genre genre) {
        return movieRepository.getAllMoviesByGenres(genre);
    }
}
