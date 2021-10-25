package com.example.exercise1.service;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.repositories.ActorsRepository;
import com.example.exercise1.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService {

    private final ActorsRepository actorsRepository;
    private final MoviesRepository moviesRepository;

    public ActorsService(ActorsRepository actorsRepository, MoviesRepository moviesRepository) {
        this.actorsRepository = actorsRepository;
        this.moviesRepository = moviesRepository;
    }

    public Actor getActorByName(String name) {
        return actorsRepository.getActorByName(name);
    }

    public List<Actor> getAllActors() {
        return actorsRepository.findAll();
    }

    public List<Actor> getAllActorsByMovieName(String movieName) {
        return actorsRepository.getAllActorsByMovies(moviesRepository.getMovieByName(movieName));
    }
}
