package com.example.exercise1.service;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.repositories.ActorRepository;
import com.example.exercise1.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public Actor getActorByName(String name) {
        return actorRepository.getActorByName(name);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public List<Actor> getAllActorsByMovieName(String movieName) {
        return actorRepository.getAllActorsByMovies(movieRepository.getMovieByName(movieName));
    }
}
