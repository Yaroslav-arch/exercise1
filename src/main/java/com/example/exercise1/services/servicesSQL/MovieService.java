package com.example.exercise1.services.servicesSQL;

import com.example.exercise1.entities.entitiesSQL.Movie;
import com.example.exercise1.repositories.sqlRepositories.MovieRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Inject
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public List<Movie> getAllMoviesByActorsName(String actorName) {
        return movieRepository.getAllMoviesByActorsName(actorName);
    }

    public List<Movie> getAllMoviesByGenreName(String genreName) {
        return movieRepository.getAllMoviesByGenreName(genreName);
    }
}
