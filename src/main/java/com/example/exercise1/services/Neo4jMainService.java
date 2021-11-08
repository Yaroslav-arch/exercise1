package com.example.exercise1.services;

import com.example.exercise1.entities.dto.*;
import com.example.exercise1.services.servicesNeo4j.*;
import com.example.exercise1.utils.DTOConverterNeo4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "false", matchIfMissing = true)
public class Neo4jMainService implements MainService {

    private final ActorService actorService;
    private final DirectorService directorService;
    private final GenreService genreService;
    private final MovieService movieService;
    private final UserService userService;
    private final DTOConverterNeo4j converter;


    @Inject
    public Neo4jMainService(ActorService actorService, DirectorService directorService, GenreService genreService, MovieService movieService, UserService userService, DTOConverterNeo4j converter) {
        this.actorService = actorService;
        this.directorService = directorService;
        this.genreService = genreService;
        this.movieService = movieService;
        this.userService = userService;
        this.converter = converter;
    }

    public List<ActorDTO> getAllActors() {
        return actorService.getAllActors().stream().map(converter::fromActorToDTO).collect(Collectors.toList());
    }

    public List<ActorDTO> getAllActorsByMovieName(String movieName) {
        return actorService.getAllActorsByMovieName(movieName).stream().map(converter::fromActorToDTO).collect(Collectors.toList());

    }

    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAllDirectors().stream().map(converter::fromDirectorToDTO).collect(Collectors.toList());
    }

    public List<GenreDTO> getAllGenres() {
        return genreService.getAllGenres().stream().map(converter::fromGenreToDTO).collect(Collectors.toList());
    }

    public GenreDTO getGenreByName(String name) {
        return converter.fromGenreToDTO(genreService.getGenreByName(name));
    }

    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies().stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public MovieDTO getMovieByName(String name) {
        return converter.fromMovieToDTO(movieService.getMovieByName(name));
    }

    public List<MovieDTO> getAllMoviesByActorsName(String actorName) {
        return movieService.getAllMoviesByActorsName(actorName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public List<MovieDTO> getAllMoviesByGenreName(String genreName) {
        return movieService.getAllMoviesByGenreName(genreName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream().map(converter::fromUserToDTO).collect(Collectors.toList());
    }
}
