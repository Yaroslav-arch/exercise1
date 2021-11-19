package com.example.exercise1.sql.repository;

import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.MovieRepositorySql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"datasource.rdbms=true"})
public class MovieRepositorySqlTest {

    @Inject
    private MovieRepositorySql movieRepositorySql;

    @Test
    public void getAllMoviesByActorsNameTest() {
        String actorName = "Keanu Reeves";
        String movieName = "Matrix";
        String movieName1 = "John Wick";
        List<MovieSql> movies = movieRepositorySql.getByActors_Name(actorName);

        Assertions.assertEquals(2, movies.size());
        Assertions.assertNotEquals(movies.get(0), movies.get(1));
        Assertions.assertTrue(movies.stream().map(MovieSql::getName).anyMatch(movieName::equals));
        Assertions.assertTrue(movies.stream().map(MovieSql::getName).anyMatch(movieName1::equals));
    }

    @Test
    public void getAllMoviesByGenreNameTest() {
        String genreName = "action";
        String movieName = "Matrix";
        String movieName1 = "John Wick";
        List<MovieSql> movies = movieRepositorySql.getByGenres_Name(genreName);

        Assertions.assertEquals(2, movies.size());
        Assertions.assertNotEquals(movies.get(0), movies.get(1));
        Assertions.assertTrue(movies.stream().map(MovieSql::getName).anyMatch(movieName::equals));
        Assertions.assertTrue(movies.stream().map(MovieSql::getName).anyMatch(movieName1::equals));
    }

    @Test
    public void findByNameTestNull() {
        String movieName = "BlaBlaBla";
        Assertions.assertFalse(movieRepositorySql.findByName(movieName).isPresent());
    }

    @Test
    public void findByNameTestNotNull() {
        String movieName = "Matrix";
        Assertions.assertTrue(movieRepositorySql.findByName(movieName).isPresent());
        Assertions.assertEquals(movieName, movieRepositorySql.findByName(movieName).get().getName());
    }

    @Test
    public void saveMovieTest() {
        String movieName = "Some Movie Name";
        MovieSql movie = MovieSql.builder()
                .name(movieName)
                .duration(90)
                .build();
        MovieSql savedMovie = movieRepositorySql.save(movie);
        MovieSql movieByName = movieRepositorySql.getMovieByName(movieName);

        Assertions.assertTrue(movieRepositorySql.findByName(movieName).isPresent());
        Assertions.assertNotNull(movieByName.getId());
        movie.setId(savedMovie.getId());
        Assertions.assertEquals(movie, savedMovie);
        assertThat(savedMovie).usingRecursiveComparison().isEqualTo(savedMovie);
    }
}
