package com.example.exercise1.service;

import com.example.exercise1.dto.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {
    List<ActorDTO> getAllActors();

    List<ActorDTO> getAllActorsByMovieName(String movieName);

    List<DirectorDTO> getAllDirectors();

    List<GenreDTO> getAllGenres();

    GenreDTO getGenreByName(String name);

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieByName(String name);

    List<MovieDTO> getAllMoviesByActorsName(String actorName);

    List<MovieDTO> getAllMoviesByGenreName(String genreName);

    List<UserDTO> getAllUsers();
}
