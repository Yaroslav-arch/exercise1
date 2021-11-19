package com.example.exercise1.sql.service;


import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.entitySql.GenreSql;
import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.MovieRepositorySql;
import com.example.exercise1.sql.serviceSql.MovieServiceSql;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieServiceSqlTest {

    @Inject
    private MovieServiceSql movieServiceSql;

    @MockBean
    private static MovieRepositorySql movieRepositorySql;

    @Before
    public void setUp() {
        ActorSql actorSql = new ActorSql(1L,"Mel Gibson");
        List<ActorSql> actorSqlList = new ArrayList<>();
        actorSqlList.add(actorSql);
        GenreSql genreSql = new GenreSql(1L, "action");
        List<GenreSql> genres = new ArrayList<>();
        genres.add(genreSql);
        MovieSql movieSql1 = MovieSql.builder().id(1L).name("Mad Max").actors(actorSqlList).genres(genres).build();
        MovieSql movieSql2 = MovieSql.builder().id(2L).name("Lethal Weapon").actors(actorSqlList).genres(genres).build();
        List<MovieSql> movies = new ArrayList<>();
        movies.add(movieSql1);
        movies.add(movieSql2);


        Mockito.when(movieRepositorySql.getByActors_Name("Mel Gibson"))
                .thenReturn(movies);
    }

    @Test
    public void getAllMoviesByActorsName() {
        String actorsName = "Mel Gibson";
        Assertions.assertNotNull(movieServiceSql.getAllMoviesByActorsName(actorsName));
    }

    @Test
    public void getAllMoviesByGenre() {
        GenreSql genre = new GenreSql(1L,"action");
        Assertions.assertNotNull(movieServiceSql.getAllMoviesByGenreName(genre.getName()));
    }
}
