package com.example.exercise1.sql.serviceSql;

import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.MovieRepositorySql;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return movieRepositorySql.getByActors_Name(actorName);
    }

    public List<MovieSql> getAllMoviesByGenreName(String genreName) {
        return movieRepositorySql.getByGenres_Name(genreName);
    }

    @Transactional
    public void saveMovie(MovieSql movie) {
        movieRepositorySql.findByName(movie.getName())
                .ifPresent(movieSql -> movieRepositorySql.delete(movie));
        movieRepositorySql.save(movie);
    }

    public void saveMovies(List<MovieSql> movies) {
        movies.forEach(this::saveMovie);
    }
}
