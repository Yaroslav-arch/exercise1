package com.example.exercise1.repositories;

import com.example.exercise1.BasicNeo4jTest;
import com.example.exercise1.entities.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import javax.inject.Inject;
import java.util.List;

@DataNeo4jTest
class MovieNeo4jTest extends BasicNeo4jTest {

    @Inject
    private MovieRepository movieRepository;

    @Test
    public void getAllMoviesByActorsNameTest() {

        String actorName = "Keanu Reeves";
        List<Movie> movies = movieRepository.getAllMoviesByActorsName(actorName);
        Assertions.assertEquals(movies.size(), 2);
        Assertions.assertNotEquals(movies.get(0), movies.get(1));
    }
}