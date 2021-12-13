package com.example.exercise1.sql;

import com.example.exercise1.dto.*;
import com.example.exercise1.service.MainService;
import com.example.exercise1.sql.serviceSql.*;
import com.example.exercise1.utils.DTOConverterSQL;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("postgres")
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

    public MainServiceSql(){}

    @Override
    public List<ActorDTO> getAllActors() {
        return actorServiceSql.getAllActors().stream().map(converter::fromActorToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getAllActorsByMovieName(String movieName) {
        return actorServiceSql.getAllActorsByMovieName(movieName).stream().map(converter::fromActorToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DirectorDTO> getAllDirectors() {
        return directorServiceSql.getAllDirectors().stream().map(converter::fromDirectorToDTO).collect(Collectors.toList());
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreServiceSql.getAllGenres().stream().map(converter::fromGenreToDTO).collect(Collectors.toList());
    }

    @Override
    public GenreDTO getGenreByName(String name) {
        return converter.fromGenreToDTO(genreServiceSql.getGenreByName(name));
    }

    @Override
    public MovieDtoList getAllMovies() {
        return new MovieDtoList(movieServiceSql.getAllMovies().stream().map(converter::fromMovieToDTO).collect(Collectors.toList()));
    }

    @Override
    public MovieDTO getMovieByName(String name) {
        return converter.fromMovieToDTO(movieServiceSql.getMovieByName(name));
    }

    @Override
    public List<MovieDTO> getAllMoviesByActorsName(String actorName) {
        return movieServiceSql.getAllMoviesByActorsName(actorName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllMoviesByGenreName(String genreName) {
        return movieServiceSql.getAllMoviesByGenreName(genreName).stream().map(converter::fromMovieToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userServiceSql.getAllUsers().stream().map(converter::fromUserToDTO).collect(Collectors.toList());
    }

    @Override
    public void saveActor(ActorDTO actorDTO) {
        actorServiceSql.saveActor(converter.toActorFromDto(actorDTO));
    }

    @Override
    public void saveDirector(DirectorDTO directorDTO) {
        directorServiceSql.saveDirector(converter.toDirectorFromDto(directorDTO));
    }

    @Override
    public void saveGenre(GenreDTO genreDTO) {
        genreServiceSql.saveGenre(converter.toGenreFromDto(genreDTO));
    }

    @Override
    public void saveMovie(MovieDTO movieDTO) {
        movieServiceSql.saveMovie(converter.toMovieFromDto(movieDTO));
    }

    @Override
    public void saveMovies(List<MovieDTO> movies) {
        movieServiceSql.saveMovies(movies.stream().map(converter::toMovieFromDto).collect(Collectors.toList()));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userServiceSql.saveUser(converter.toUserFromDto(userDTO));
    }

}
