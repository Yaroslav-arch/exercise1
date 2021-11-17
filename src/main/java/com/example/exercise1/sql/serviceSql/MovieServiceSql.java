package com.example.exercise1.sql.serviceSql;

import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.MovieRepositorySql;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MovieServiceSql {

    private final MovieRepositorySql movieRepositorySql;

    @Inject
    public MovieServiceSql(MovieRepositorySql movieRepositorySql) {
        this.movieRepositorySql = movieRepositorySql;
    }

    public List<MovieSql> getAllMovies() {
        return movieRepositorySql.findAll();
    }

    public MovieSql getMovieByName(String name) {
        return movieRepositorySql.getMovieByName(name);
    }

    public List<MovieSql> getAllMoviesByActorsName(String actorName) {
        return movieRepositorySql.getAllMoviesByActorsName(actorName);
    }

    public List<MovieSql> getAllMoviesByGenreName(String genreName) {
        return movieRepositorySql.getAllMoviesByGenreName(genreName);
    }

    public void saveMovie(MovieSql movie) {
        movieRepositorySql.save(movie);
    }
}
