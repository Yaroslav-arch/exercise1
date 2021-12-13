package com.example.exercise1.sql.service;


import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.entitySql.GenreSql;
import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.MovieRepositorySql;
import com.example.exercise1.sql.serviceSql.MovieServiceSql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("postgres")
public class MovieServiceSqlTest {

    @Inject
    private MovieServiceSql movieServiceSql;

    @MockBean
    private static MovieRepositorySql movieRepositorySql;

    private final MovieSql movie3 = MovieSql.builder().name("Mad Max").duration(65).build();
    private final MovieSql someMovie = MovieSql.builder().name("Some Movie").duration(65).build();

    @BeforeEach
    public void setUp() {
        ActorSql actorSql = new ActorSql(1L, "Mel Gibson");
        List<ActorSql> actorSqlList = new ArrayList<>();
        actorSqlList.add(actorSql);
        GenreSql genreSql = new GenreSql(1L, "action");
        List<GenreSql> genres = new ArrayList<>();
        genres.add(genreSql);
        MovieSql movie1 = MovieSql.builder().id(1L).name("Mad Max").actors(actorSqlList).genres(genres).build();
        MovieSql movie2 = MovieSql.builder().id(2L).name("Lethal Weapon").actors(actorSqlList).genres(genres).build();
        List<MovieSql> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);


        Mockito.when(movieRepositorySql.getByActors_Name("Mel Gibson"))
                .thenReturn(movies);

        Mockito.when(movieRepositorySql.findByName(movie1.getName()))
                .thenReturn(Optional.of(movie3));

        Mockito.when(movieRepositorySql.findByName(someMovie.getName()))
                .thenReturn(Optional.empty());

        Mockito.doNothing().when(movieRepositorySql).delete(movie3);
    }

    @Test
    public void getAllMoviesByActorsName() {
        String actorsName = "Mel Gibson";
        Assertions.assertNotNull(movieServiceSql.getAllMoviesByActorsName(actorsName));
    }

    @Test
    public void getAllMoviesByGenre() {
        GenreSql genre = new GenreSql(1L, "action");
        Assertions.assertNotNull(movieServiceSql.getAllMoviesByGenreName(genre.getName()));
    }

    @Test
    public void saveMovieTestWithDelete() {
        movieServiceSql.saveMovie(movie3);
        verify(movieRepositorySql, times(1)).findByName(movie3.getName());
        verify(movieRepositorySql, times(1)).delete(movie3);
        verify(movieRepositorySql, times(1)).save(movie3);

    }

    @Test
    public void saveMovieTestWithoutDelete() {
        movieServiceSql.saveMovie(someMovie);
        verify(movieRepositorySql, times(1)).findByName(someMovie.getName());
        verify(movieRepositorySql, times(1)).save(someMovie);

    }
}
