package com.example.exercise1.neo4j;

import com.example.exercise1.dto.*;
import com.example.exercise1.neo4j.serviceNeo4j.*;
import com.example.exercise1.service.MainService;
import com.example.exercise1.utils.DTOConverterNeo4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("neo4j")
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

    public MainServiceNeo4j() {
    }

    @Override
    public List<ActorDTO> getAllActors() {
        return actorServiceNeo4j.getAllActors().stream().map(converter::fromActorToDto).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getAllActorsByMovieName(String movieName) {
        return actorServiceNeo4j.getAllActorsByMovieName(movieName).stream().map(converter::fromActorToDto).collect(Collectors.toList());

    }

    @Override
    public List<DirectorDTO> getAllDirectors() {
        return directorServiceNeo4j.getAllDirectors().stream().map(converter::fromDirectorToDto).collect(Collectors.toList());
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreServiceNeo4j.getAllGenres().stream().map(converter::fromGenreToDto).collect(Collectors.toList());
    }

    @Override
    public GenreDTO getGenreByName(String name) {
        return converter.fromGenreToDto(genreServiceNeo4j.getGenreByName(name));
    }

    @Override
    public MovieDtoList getAllMovies() {
        return new MovieDtoList(movieServiceNeo4j.getAllMovies().stream().map(converter::fromMovieToDto).collect(Collectors.toList()));
    }

    @Override
    public MovieDTO getMovieByName(String name) {
        return converter.fromMovieToDto(movieServiceNeo4j.getMovieByName(name));
    }

    @Override
    public List<MovieDTO> getAllMoviesByActorsName(String actorName) {
        return movieServiceNeo4j.getAllMoviesByActorsName(actorName).stream().map(converter::fromMovieToDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllMoviesByGenreName(String genreName) {
        return movieServiceNeo4j.getAllMoviesByGenreName(genreName).stream().map(converter::fromMovieToDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userServiceNeo4j.getAllUsers().stream().map(converter::fromUserToDto).collect(Collectors.toList());
    }

    @Override
    public void saveActor(ActorDTO actorDTO) {
        actorServiceNeo4j.saveActor(converter.toActorFromDto(actorDTO));
    }

    @Override
    public void saveDirector(DirectorDTO directorDTO) {
        directorServiceNeo4j.saveDirector(converter.toDirectorFromDto(directorDTO));
    }

    @Override
    public void saveGenre(GenreDTO genreDTO) {
        genreServiceNeo4j.saveGenre(converter.toGenreFromDto(genreDTO));
    }

    @Override
    public void saveMovie(MovieDTO movieDTO) {
        movieServiceNeo4j.saveMovie(converter.toMovieFromDto(movieDTO));
    }

    @Override
    public void saveMovies(List<MovieDTO> movies) {
        movieServiceNeo4j.saveMovies(movies.stream().map(converter::toMovieFromDto).collect(Collectors.toList()));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userServiceNeo4j.saveUser(converter.toUserFromDto(userDTO));
    }
}