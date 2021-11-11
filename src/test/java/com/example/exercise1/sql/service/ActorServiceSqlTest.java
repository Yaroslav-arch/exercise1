package com.example.exercise1.sql.service;

import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.entitySql.GenreSql;
import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import com.example.exercise1.sql.serviceSql.ActorServiceSql;
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
public class ActorServiceSqlTest {

    @Inject
    private ActorServiceSql actorServiceSql;

    @MockBean
    private static ActorRepositorySql actorRepositorySql;

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

        Mockito.when(actorRepositorySql.getAllActorsByMovieName("Mad Max"))
                .thenReturn(actors);
    }

    @Test
    public void getAllActorsByMovieName() {
        String movieName = "Mad Max";
        Assertions.assertNotNull(actorServiceSql.getAllActorsByMovieName(movieName));
    }

}
