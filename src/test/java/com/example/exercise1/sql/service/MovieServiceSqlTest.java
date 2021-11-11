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
        ActorSql actor = new ActorSql();
        actor.setName("Mel Gibson");
        List<ActorSql> actors = new ArrayList<>();
        actors.add(actor);
        GenreSql genre = new GenreSql();
        genre.setName("action");
        List<GenreSql> genres = new ArrayList<>();
        genres.add(genre);
        MovieSql movie1 = new MovieSql();
        movie1.setName("Mad Max");
        movie1.setActors(actors);
        movie1.setGenres(genres);
        MovieSql movie2 = new MovieSql();
        movie2.setName("Lethal weapon");
        movie2.setActors(actors);
        movie2.setGenres(genres);
        List<MovieSql> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);


        Mockito.when(movieRepositorySql.getAllMoviesByActorsName("Mel Gibson"))
                .thenReturn(movies);
    }

    @Test
    public void getAllMoviesByActorsName() {
        String actorsName = "Mel Gibson";
        Assertions.assertNotNull(movieServiceSql.getAllMoviesByActorsName(actorsName));
    }

    @Test
    public void getAllMoviesByGenre() {
        GenreSql genre = new GenreSql();
        genre.setName("Action");
        Assertions.assertNotNull(movieServiceSql.getAllMoviesByGenreName(genre.getName()));
    }
}
