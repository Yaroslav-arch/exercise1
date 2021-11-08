package com.example.exercise1.services;

import com.example.exercise1.entities.entitiesSQL.*;
import com.example.exercise1.services.servicesSQL.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "true")
public class SQLMainService implements MainService{

    private final ActorService actorService;
    private final DirectorService directorService;
    private final GenreService genreService;
    private final MovieService movieService;
    private final UserService userService;


    @Inject
    public SQLMainService(ActorService actorService, DirectorService directorService, GenreService genreService, MovieService movieService, UserService userService) {
        this.actorService = actorService;
        this.directorService = directorService;
        this.genreService = genreService;
        this.movieService = movieService;
        this.userService = userService;
    }

    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    public List<Actor> getAllActorsByMovieName(String movieName) {
        return actorService.getAllActorsByMovieName(movieName);
    }

    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }

    public Genre getGenreByName(String name){
        return genreService.getGenreByName(name);
    }

    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    public Movie getMovieByName(String name) {
        return movieService.getMovieByName(name);
    }

    public List<Movie> getAllMoviesByActorsName(String actorName) {
        return movieService.getAllMoviesByActorsName(actorName);
    }

    public List<Movie> getAllMoviesByGenreName(String genreName) {
        return movieService.getAllMoviesByGenreName(genreName);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
