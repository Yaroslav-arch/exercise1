package com.example.exercise1.neo4j.repository;

import com.example.exercise1.neo4j.BasicNeo4jTest;
import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.MovieRepositoryNeo4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Arrays;
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
//    @Transactional
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
    @Test
//    @Transactional
    public void saveAllTest() {
        MovieNeo4j movie1 = MovieNeo4j.builder()
                .name("Movie1")
                .duration(90)
                .build();
        MovieNeo4j movie2 = MovieNeo4j.builder()
                .name("Movie2")
                .duration(85)
                .build();
        MovieNeo4j movie3 = MovieNeo4j.builder()
                .name("Movie3")
                .duration(95)
                .build();
        List<MovieNeo4j> movies = Arrays.asList(movie1, movie2, movie3);
        movieRepositoryNeo4j.saveAll(movies);
        List<MovieNeo4j> found = movieRepositoryNeo4j.findAll();

        Assertions.assertTrue(found.stream()
                .map(MovieNeo4j::getName)
                .anyMatch(movie1.getName()::equals));

        Assertions.assertTrue(found.stream()
                .map(MovieNeo4j::getName)
                .anyMatch(movie2.getName()::equals));

        Assertions.assertTrue(found.stream()
                .map(MovieNeo4j::getName)
                .anyMatch(movie3.getName()::equals));
    }

    @Test
    public void findAllTest(){
        List<MovieNeo4j> found = movieRepositoryNeo4j.findAll();
        Assertions.assertEquals(2,found.size());
    }
    
}