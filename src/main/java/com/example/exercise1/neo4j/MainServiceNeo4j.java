package com.example.exercise1.neo4j;

import com.example.exercise1.dto.*;
import com.example.exercise1.neo4j.serviceNeo4j.*;
import com.example.exercise1.service.MainService;
import com.example.exercise1.utils.DTOConverterNeo4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

//@Service
//@ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "false", matchIfMissing = true)
public class MainServiceNeo4j implements MainService {
    @Inject
    private ActorServiceNeo4j actorServiceNeo4j;
    @Inject
    private DirectorServiceNeo4j directorServiceNeo4j;
    @Inject
    private GenreServiceNeo4j genreServiceNeo4j;
    @Inject
    private MovieServiceNeo4j movieServiceNeo4j;
    @Inject
    private UserServiceNeo4j userServiceNeo4j;
    @Inject
    private DTOConverterNeo4j converter;


//    @Inject
//    public MainServiceNeo4j(ActorServiceNeo4j actorServiceNeo4j, DirectorServiceNeo4j directorServiceNeo4j, GenreServiceNeo4j genreServiceNeo4j, MovieServiceNeo4j movieServiceNeo4j, UserServiceNeo4j userServiceNeo4j, DTOConverterNeo4j converter) {
//        this.actorServiceNeo4j = actorServiceNeo4j;
//        this.directorServiceNeo4j = directorServiceNeo4j;
//        this.genreServiceNeo4j = genreServiceNeo4j;
//        this.movieServiceNeo4j = movieServiceNeo4j;
//        this.userServiceNeo4j = userServiceNeo4j;
//        this.converter = converter;
//    }

    public MainServiceNeo4j() {
    }


    public List<ActorDTO> getAllActors() {
        return actorServiceNeo4j.getAllActors().stream().map(converter::fromActorToDTO).collect(Collectors.toList());
    }

    public List<ActorDTO> getAllActorsByMovieName(String movieName) {
        return actorServiceNeo4j.getAllActorsByMovieName(movieName).stream().map(converter::fromActorToDTO).collect(Collectors.toList());

    }

    public List<DirectorDTO> getAllDirectors() {
        return directorServiceNeo4j.getAllDirectors().stream().map(converter::fromDirectorToDTO).collect(Collectors.toList());
    }

    public List<GenreDTO> getAllGenres() {
        return genreServiceNeo4j.getAllGenres().stream().map(converter::fromGenreToDTO).collect(Collectors.toList());
    }

    public GenreDTO getGenreByName(String name) {
        return converter.fromGenreToDTO(genreServiceNeo4j.getGenreByName(name));
    }

    public List<MovieDTO> getAllMovies() {
        return movieServiceNeo4j.getAllMovies().stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public MovieDTO getMovieByName(String name) {
        return converter.fromMovieToDTO(movieServiceNeo4j.getMovieByName(name));
    }

    public List<MovieDTO> getAllMoviesByActorsName(String actorName) {
        return movieServiceNeo4j.getAllMoviesByActorsName(actorName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public List<MovieDTO> getAllMoviesByGenreName(String genreName) {
        return movieServiceNeo4j.getAllMoviesByGenreName(genreName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getAllUsers() {
        return userServiceNeo4j.getAllUsers().stream().map(converter::fromUserToDTO).collect(Collectors.toList());
    }
}
