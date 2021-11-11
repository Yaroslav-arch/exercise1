package com.example.exercise1.sql;

import com.example.exercise1.dto.*;
import com.example.exercise1.service.MainService;
import com.example.exercise1.sql.serviceSql.*;
import com.example.exercise1.utils.DTOConverterSQL;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

//@Service
//@ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "true")
public class MainServiceSql implements MainService {

    @Inject
    private ActorServiceSql actorServiceSql;
    @Inject
    private DirectorServiceSql directorServiceSql;
    @Inject
    private GenreServiceSql genreServiceSql;
    @Inject
    private MovieServiceSql movieServiceSql;
    @Inject
    private UserServiceSql userServiceSql;
    @Inject
    private DTOConverterSQL converter;


//    @Inject
//    public MainServiceSql(ActorServiceSql actorServiceSql, DirectorServiceSql directorServiceSql, GenreServiceSql genreServiceSql, MovieServiceSql movieServiceSql, UserServiceSql userServiceSql, DTOConverterSQL converter) {
//        this.actorServiceSql = actorServiceSql;
//        this.directorServiceSql = directorServiceSql;
//        this.genreServiceSql = genreServiceSql;
//        this.movieServiceSql = movieServiceSql;
//        this.userServiceSql = userServiceSql;
//        this.converter = converter;
//    }

    public MainServiceSql(){}

    public List<ActorDTO> getAllActors() {
        return actorServiceSql.getAllActors().stream().map(converter::fromActorToDTO).collect(Collectors.toList());
    }

    public List<ActorDTO> getAllActorsByMovieName(String movieName) {
        return actorServiceSql.getAllActorsByMovieName(movieName).stream().map(converter::fromActorToDTO).collect(Collectors.toList());

    }

    public List<DirectorDTO> getAllDirectors() {
        return directorServiceSql.getAllDirectors().stream().map(converter::fromDirectorToDTO).collect(Collectors.toList());
    }

    public List<GenreDTO> getAllGenres() {
        return genreServiceSql.getAllGenres().stream().map(converter::fromGenreToDTO).collect(Collectors.toList());
    }

    public GenreDTO getGenreByName(String name) {
        return converter.fromGenreToDTO(genreServiceSql.getGenreByName(name));
    }

    public List<MovieDTO> getAllMovies() {
        return movieServiceSql.getAllMovies().stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public MovieDTO getMovieByName(String name) {
        return converter.fromMovieToDTO(movieServiceSql.getMovieByName(name));
    }

    public List<MovieDTO> getAllMoviesByActorsName(String actorName) {
        return movieServiceSql.getAllMoviesByActorsName(actorName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public List<MovieDTO> getAllMoviesByGenreName(String genreName) {
        return movieServiceSql.getAllMoviesByGenreName(genreName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getAllUsers() {
        return userServiceSql.getAllUsers().stream().map(converter::fromUserToDTO).collect(Collectors.toList());
    }

}
