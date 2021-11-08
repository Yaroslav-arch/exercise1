package com.example.exercise1.services;

import com.example.exercise1.entities.entitiesNeo4j.*;
import com.example.exercise1.entities.entitiesSQL.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {
    public List<com.example.exercise1.entities.entitiesSQL.Actor> getAllActors();

    public List<Actor> getAllActorsByMovieName(String movieName);

    public List<Director> getAllDirectors();

    public List<Genre> getAllGenres();

    public Genre getGenreByName(String name);

    public List<Movie> getAllMovies();

    public Movie getMovieByName(String name);

    public List<Movie> getAllMoviesByActorsName(String actorName);

    public List<Movie> getAllMoviesByGenreName(String genreName);

    public List<User> getAllUsers();
}
