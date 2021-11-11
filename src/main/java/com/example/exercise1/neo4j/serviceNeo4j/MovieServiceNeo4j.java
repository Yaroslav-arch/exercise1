package com.example.exercise1.neo4j.serviceNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.MovieRepositoryNeo4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MovieServiceNeo4j {
    private final MovieRepositoryNeo4j movieRepositoryNeo4j;

    @Inject
    public MovieServiceNeo4j(MovieRepositoryNeo4j movieRepositoryNeo4j) {
        this.movieRepositoryNeo4j = movieRepositoryNeo4j;
    }

    public List<MovieNeo4j> getAllMovies() {
        return movieRepositoryNeo4j.findAll();
    }

    public MovieNeo4j getMovieByName(String name) {
        return movieRepositoryNeo4j.getMovieByName(name);
    }

    public List<MovieNeo4j> getAllMoviesByActorsName(String actorName) {
        return movieRepositoryNeo4j.getAllMoviesByActorsName(actorName);
    }

    public List<MovieNeo4j> getAllMoviesByGenreName(String genreName) {
        return movieRepositoryNeo4j.getAllMoviesByGenreName(genreName);
    }

}