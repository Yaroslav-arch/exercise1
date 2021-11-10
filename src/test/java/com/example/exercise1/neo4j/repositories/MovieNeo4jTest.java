package com.example.exercise1.neo4j.repositories;

import com.example.exercise1.neo4j.BasicNeo4jTest;
import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.MovieRepositoryNeo4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import javax.inject.Inject;
import java.util.List;

@DataNeo4jTest
class MovieNeo4jTest extends BasicNeo4jTest {

    @Inject
    private MovieRepositoryNeo4j movieRepositoryNeo4j;

    @Test
    public void getAllMoviesByActorsNameTest() {

        String actorName = "Keanu Reeves";
        String movie1Name = "Matrix";
        String movie2Name = "John Wick";
        List<MovieNeo4j> movieNeo4js = movieRepositoryNeo4j.getAllMoviesByActorsName(actorName);
        Assertions.assertEquals(movieNeo4js.size(), 2);
        Assertions.assertNotEquals(movieNeo4js.get(0), movieNeo4js.get(1));
        Assertions.assertTrue(movieNeo4js.stream().map(MovieNeo4j::getName).anyMatch(movie1Name::equals));
        Assertions.assertTrue(movieNeo4js.stream().map(MovieNeo4j::getName).anyMatch(movie2Name::equals));
    }
}