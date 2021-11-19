package com.example.exercise1.neo4j.repository;

import com.example.exercise1.neo4j.BasicNeo4jTest;
import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.MovieRepositoryNeo4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataNeo4jTest(properties = {"datasource.rdbms=false"})
class MovieRepositoryNeo4jTest extends BasicNeo4jTest {

    @Inject
    private MovieRepositoryNeo4j movieRepositoryNeo4j;

    @Test
    public void getAllMoviesByActorsNameTest() {

        String actorName = "Keanu Reeves";
        String movie1Name = "Matrix";
        String movie2Name = "John Wick";
        List<MovieNeo4j> movies = movieRepositoryNeo4j.getAllMoviesByActorsName(actorName);

        Assertions.assertEquals(movies.size(), 2);
        Assertions.assertNotEquals(movies.get(0), movies.get(1));
        Assertions.assertTrue(movies.stream().map(MovieNeo4j::getName).anyMatch(movie1Name::equals));
        Assertions.assertTrue(movies.stream().map(MovieNeo4j::getName).anyMatch(movie2Name::equals));
    }

    @Test
    public void findByNameTestNull() {
        String movieName = "BlaBlaBla";
        Assertions.assertFalse(movieRepositoryNeo4j.findByName(movieName).isPresent());
    }

    @Test
    public void findByNameTestNotNull() {
        String movieName = "Matrix";
        Assertions.assertTrue(movieRepositoryNeo4j.findByName(movieName).isPresent());
        Assertions.assertEquals(movieName, movieRepositoryNeo4j.findByName(movieName).get().getName());
    }

    @Test
    public void saveMovieTest() {
        String movieName = "Some Movie Name";
        MovieNeo4j movie = MovieNeo4j.builder()
                .name(movieName)
                .duration(90)
                .build();
        MovieNeo4j savedMovie = movieRepositoryNeo4j.save(movie);
        MovieNeo4j movieByName = movieRepositoryNeo4j.getMovieByName(movieName);

        Assertions.assertTrue(movieRepositoryNeo4j.findByName(movieName).isPresent());
        Assertions.assertNotNull(movieByName.getId());
        movie.setId(savedMovie.getId());
        Assertions.assertEquals(movie, savedMovie);
        assertThat(savedMovie).usingRecursiveComparison().isEqualTo(savedMovie);
    }
}